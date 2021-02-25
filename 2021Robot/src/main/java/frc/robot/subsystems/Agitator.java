// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Agitator extends SubsystemBase {
  private final CANSparkMax bucket;

  /** Creates a new Agitator. */
  public Agitator() {
    bucket = new CANSparkMax(Constants.BUCKET_CHANNEL, MotorType.kBrushless);
    bucket.setOpenLoopRampRate(Constants.AGITATOR_RAMP);
  }

  public void runAgitator(int multiplier) {
    bucket.set(Constants.BUCKET_SPEED * multiplier);
  }

  public void stopAgitator() {
    bucket.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
