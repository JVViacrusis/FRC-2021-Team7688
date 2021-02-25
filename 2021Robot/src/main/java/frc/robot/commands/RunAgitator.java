// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Agitator;

public class RunAgitator extends CommandBase {
  private final Agitator agitator;
  private final Timer timer = new Timer();
  private int multiplier = -1;
  private double lastTime;

  /** Creates a new RunAgitator. */
  public RunAgitator(Agitator a) {
    // Use addRequirements() here to declare subsystem dependencies.
    agitator = a;
    addRequirements(agitator);

    timer.reset();
    timer.start();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() >= (lastTime + Constants.AGITIME)) {
      lastTime = timer.get();
      multiplier = multiplier * -1;
      agitator.runAgitator(multiplier); 
    } else {
      agitator.runAgitator(multiplier); 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
