// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveLimelight;
import frc.robot.commands.Reverse;
import frc.robot.commands.RunSystem;
import frc.robot.commands.StopDrive;
import frc.robot.commands.StopLauncher;
import frc.robot.subsystems.Agitator;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.LimelightActuator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final Launcher launcher = new Launcher();
  private final Agitator agitator = new Agitator();
  private final RunSystem runSystem = new RunSystem(launcher, agitator);
  private final Reverse reverse = new Reverse(launcher);
  private final StopLauncher stoplauncher = new StopLauncher(launcher);

  private final Drivetrain drivetainSub = new Drivetrain();
  private final Drive driveCommand = new Drive(drivetainSub);
  private final StopDrive stopCommand = new StopDrive(drivetainSub);

  private final LimelightActuator limelightActuator = new LimelightActuator();
  private final MoveLimelight moveLimelight = new MoveLimelight(limelightActuator);

  private final Joystick joystick = new Joystick(0);
  private final JoystickButton driveTrigger = new JoystickButton(joystick, Constants.DRIVE_TRIGGER);
  private final JoystickButton launcherTrigger = new JoystickButton(joystick, Constants.LAUNCHER_TRIGGER);
  private final JoystickButton limelightActuatorTrigger = new JoystickButton(joystick, Constants.LIMELIGHT_TRIGGER);
  private final JoystickButton reverseTrigger = new JoystickButton(joystick, Constants.REVERSE_TRIGGER);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveTrigger.whenPressed(driveCommand);
    driveTrigger.whenReleased(stopCommand);
    launcherTrigger.whenPressed(runSystem);
    limelightActuatorTrigger.whenPressed(moveLimelight);
    reverseTrigger.whenPressed(reverse);
    reverseTrigger.whenReleased(stoplauncher);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
