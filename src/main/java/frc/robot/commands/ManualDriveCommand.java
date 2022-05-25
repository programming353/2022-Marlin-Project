// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ManualDriveCommand extends CommandBase {
  private final DriveSubsystem driveSubsystem;

  private DoubleSupplier forward;
  private DoubleSupplier turn;

  /** Creates a new ManualDriveCommand. */
  public ManualDriveCommand(DoubleSupplier forward, DoubleSupplier turn, DriveSubsystem drive) {
    driveSubsystem = drive;

    this.forward = forward;
    this.turn = turn;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Math.abs(forward.getAsDouble()) < 0.02 && Math.abs(turn.getAsDouble()) < 0.02) {
      driveSubsystem.manualDrive(0, 0);
    } else {
      driveSubsystem.manualDrive(-forward.getAsDouble() * 0.95, turn.getAsDouble() * 0.75);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      driveSubsystem.manualDrive(0, 0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
