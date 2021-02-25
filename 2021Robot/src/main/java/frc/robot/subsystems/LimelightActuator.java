// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimelightActuator extends SubsystemBase {
  private final Servo pitchActuator;
  private final Servo rotationActuator;
  private boolean isServoMax = false;

  /** Creates a new LimelightActuator. */
  public LimelightActuator() {
    pitchActuator = new Servo(Constants.LIMELIGHT_PITCH_CHANNEL);
    rotationActuator = new Servo(Constants.LIMELIGHT_ROTATE_CHANNEL);
    
    pitchActuator.setAngle(Constants.LIMELIGHT_PITCH_MIN);
    rotationActuator.setAngle(Constants.LIMELIGHT_ROTATE_MIN);
  }

  public void move() {
    if(isServoMax == true){
      pitchActuator.setAngle(Constants.LIMELIGHT_PITCH_MIN);
      rotationActuator.setAngle(Constants.LIMELIGHT_ROTATE_MIN);
      isServoMax = false;
      Constants.DRIVE_MULTIPLIER = Constants.DRIVE_MULTIPLIER * -1;
    } else {
      pitchActuator.setAngle(Constants.LIMELIGHT_PITCH_MAX);
      rotationActuator.setAngle(Constants.LIMELIGHT_ROTATE_MAX);
      isServoMax = true;
      Constants.DRIVE_MULTIPLIER = Constants.DRIVE_MULTIPLIER * -1;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
