// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.Buttons;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ManualDriveCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  private final VisionSubsystem m_visionSubsystem = new VisionSubsystem();

  private final ClimbSubsystem m_climbSubsystem = new ClimbSubsystem();

  private final Joystick driverStick = new Joystick(Constants.driverJoystickID);
  private final Joystick operatorStick = new Joystick(Constants.operatorJoystickID);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_driveSubsystem
        .setDefaultCommand(new ManualDriveCommand(driverStick::getY, driverStick::getX, m_driveSubsystem));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(operatorStick, Buttons.climbUpButton)
        .whileHeld(new RunCommand(m_climbSubsystem::climbUp, m_climbSubsystem))
        .whenReleased(new InstantCommand(m_climbSubsystem::climbDown, m_climbSubsystem));

    new JoystickButton(operatorStick, Buttons.climbDownButton)
        .whileHeld(new RunCommand(m_climbSubsystem::climbDown, m_climbSubsystem))
        .whenReleased(new InstantCommand(m_climbSubsystem::stopMotor, m_climbSubsystem));
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
