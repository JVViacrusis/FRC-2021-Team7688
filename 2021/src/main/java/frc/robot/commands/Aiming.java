// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimelightActuator;
import frc.robot.subsystems.LimelightTarget;

public class Aiming extends CommandBase {
  /** Creates a new Aiming. */
  private final PIDController pid = new PIDController(Constants.LIMELIGHT_ROTATION_KP, Constants.LIMELIGHT_ROTATION_KI,Constants.LIMELIGHT_ROTATION_KD);
  private final PIDController pidS = new PIDController(0.6, 0, 0.5);
  
  private final Drivetrain D;
  private final LimelightTarget LT;
  private final LimelightActuator LA;
  private final Timer time = new Timer();
  public Aiming(Drivetrain dtt,LimelightTarget ll,LimelightActuator la) {
    LT = ll;
    LA = la;
    D = dtt;
    addRequirements(LT);
    addRequirements(D);
    addRequirements(LA);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
    pid.reset();
    LT.Turn_on_the_light();
    
    pidS.setIntegratorRange(0.5, -0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    LA.setAngle();
    if(LT.Area()==0){
      System.out.println("SEEKING THE TARGET");
      D.drive(0, 0.45);

    } else {
      double output = pid.calculate(LT.Target()/27, Constants.LIMELIGHT_ROTATTON_SETPOINT);
      double output_spead = pidS.calculate(LT.Area(), Constants.LIMELIGHT_DISTANCE_SETPOINT);
      System.out.println("GOING TO THE TARGET "+output);
      SmartDashboard.putNumber("Set_point",pid.getSetpoint());
      SmartDashboard.putNumber("Offset", pid.getPositionError());
      SmartDashboard.putNumber("P_R", pid.getP());
      SmartDashboard.putNumber("I_R", pid.getI());
      SmartDashboard.putNumber("D_R", pid.getD());
      SmartDashboard.putNumber("PID_Rotation", output);
      SmartDashboard.putNumber("PID_Spead", output_spead);
      D.drive(output_spead, output);
      
      

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    D.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   return false;
    
    
      
    
  }
}
