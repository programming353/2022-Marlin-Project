// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class BallTransitSystem extends SubsystemBase {
  private CANSparkMax intakeMotor = new CANSparkMax(IntakeConstants.intakeMotorID, MotorType.kBrushless);

  /** Creates a new BallTransitSystem. */
  public BallTransitSystem() {
  }

  public void intake() {
    intakeMotor.set(IntakeConstants.intakeSpeed);
  }

  public void outake() {
    intakeMotor.set(-IntakeConstants.intakeSpeed);
  }

  public void stop() {
    intakeMotor.set(0);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
