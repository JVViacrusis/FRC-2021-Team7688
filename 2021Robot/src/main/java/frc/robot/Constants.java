// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int LIMELIGHT_PITCH_CHANNEL = 0;
    public static final int LIMELIGHT_ROTATE_CHANNEL = 1;

    public static final double LIMELIGHT_PITCH_MAX = 0;
    public static final double LIMELIGHT_PITCH_MIN = 180;

    public static final double LIMELIGHT_ROTATE_MAX = 180;
    public static final double LIMELIGHT_ROTATE_MIN = 0;

    //VICTOR
    public static final int FEEDER_CHANNEL = 13;
    public static final int LAUNCHER_UPPER_CHANNEL = 11;
    public static final int LAUNCHER_LOWER_CHANNEL = 12;

    //TALON
    public static final int BUCKET_CHANNEL = 2;
    
    public static final double FEEDER_RAMP = 1.5;
    public static final double LAUNCHER_RAMP = 1.5;
    public static final double AGITATOR_RAMP = 0.2;
    
    public static final double FEEDER_SPEED = 0.4;
    public static final double LAUNCHER_UPPER_SPEED = 0.48;
    public static final double LAUNCHER_LOWER_SPEED = 0.48;
    public static final double BUCKET_SPEED = 0.3;

    public static final double FEEDER_DELAY = 3;
    public static final double STOP_DELAY = 8;

    public static final int FEEDER_MULTIPLIER = -1;
    public static final int LAUNCHER_UPPER_MULTIPLIER = 1;
    public static final int LAUNCHER_LOWER_MULTIPLIER = 1;

    public static final double AGITIME = 0.9;

    public static final double MOTOR_RAMP = 1;

    public static int DRIVE_MULTIPLIER = 1;

    //VICTORS
    public static final int LEFT_FRONT_TOP_CHANNEL = 7;
    public static final int LEFT_FRONT_BOTTOM_CHANNEL = 8;
    public static final int LEFT_BACK_TOP_CHANNEL = 9;

    //TALON
    public static final int LEFT_BACK_BOTTOM_CHANNEL = 10;

    //VICTORS
    public static final int RIGHT_FRONT_TOP_CHANNEL = 4;
    public static final int RIGHT_FRONT_BOTTOM_CHANNEL = 5;
    public static final int RIGHT_BACK_TOP_CHANNEL = 6;

    //TALON
    public static final int RIGHT_BACK_BOTTOM_CHANNEL = 3;

    public static final double MAX_SPEED = 0.1;

    public static final int LAUNCHER_TRIGGER = 2;
    public static final int DRIVE_TRIGGER = 1;
    public static final int LIMELIGHT_TRIGGER = 3;
    public static final int REVERSE_TRIGGER = 4;
}
