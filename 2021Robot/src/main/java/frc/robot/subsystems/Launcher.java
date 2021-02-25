// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launcher extends SubsystemBase {
  private final VictorSPX feeder;
  private final VictorSPX launcherUpper;
  private final VictorSPX launcherLower;

  /** Creates a new Launcher. */
  public Launcher() {
    feeder = new VictorSPX(Constants.FEEDER_CHANNEL);
    launcherUpper = new VictorSPX(Constants.LAUNCHER_UPPER_CHANNEL);
    launcherLower = new VictorSPX(Constants.LAUNCHER_LOWER_CHANNEL);

    feeder.configOpenloopRamp(Constants.FEEDER_RAMP);
    launcherLower.configOpenloopRamp(Constants.LAUNCHER_RAMP);
    launcherUpper.configOpenloopRamp(Constants.LAUNCHER_RAMP);
  }

  public void startLauncher() {
    launcherUpper.set(ControlMode.PercentOutput, Constants.LAUNCHER_UPPER_SPEED * Constants.LAUNCHER_UPPER_MULTIPLIER);
    launcherLower.set(ControlMode.PercentOutput, Constants.LAUNCHER_LOWER_SPEED * Constants.LAUNCHER_LOWER_MULTIPLIER);
  }

  public void startFeeder() {
    feeder.set(ControlMode.PercentOutput, Constants.FEEDER_SPEED * Constants.FEEDER_MULTIPLIER);
  }

  public void reverse(){
    feeder.set(ControlMode.PercentOutput, Constants.FEEDER_SPEED * (Constants.FEEDER_MULTIPLIER * -.5));
  }

  public void stop() {
    feeder.set(ControlMode.PercentOutput, 0);
    launcherUpper.set(ControlMode.PercentOutput, 0);
    launcherLower.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
