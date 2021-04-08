// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Pnuematics;

public class teleDrive extends CommandBase {
  private final Pnuematics p;
  private final Drivetrain drivetrain;
  private final LED led;
  private final Joystick joystick = new Joystick(0);

  /** Creates a new Drive. */
  public teleDrive(Drivetrain dt,LED i_led,Pnuematics pp) {
    p = pp;
    drivetrain = dt;
    led = i_led;
    addRequirements(drivetrain);
    addRequirements(led);
    addRequirements(pp);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    p.Stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    led.Speed(joystick.getRawAxis(Constants.DRIVETRAIN_JOYSTICK_AXIS_SPEED));
    drivetrain.drive(-0.7*joystick.getRawAxis(Constants.DRIVETRAIN_JOYSTICK_AXIS_SPEED), 
                     0.7*joystick.getRawAxis(Constants.DRIVETRAIN_JOYSTICK_AXIS_ROTATION));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
