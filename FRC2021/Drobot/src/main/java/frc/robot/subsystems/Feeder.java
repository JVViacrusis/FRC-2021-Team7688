// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
  /** Creates a new Feeder. */
  private final VictorSPX feeder = new VictorSPX(Constants.FEEDER_MOTOR_PORT);
  /** Creates a new Feeder. */
  public Feeder() {
  }
  public void Drive(double speed){
    feeder.set(ControlMode.PercentOutput, speed);
  }
  public void Settime(double ramptime){
    feeder.configOpenloopRamp(ramptime);

  }
  public void Stopf() {
    feeder.set(ControlMode.PercentOutput, 0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
