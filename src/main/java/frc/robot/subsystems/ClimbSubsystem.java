// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase {
  private CANSparkMax climbMotor = new CANSparkMax(ClimbConstants.climbMotorID, MotorType.kBrushless);

  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem() {
  }

  public void climbUp() {
    climbMotor.set(ClimbConstants.climbMotorSpeed);
  }

  public void climbDown() {
    climbMotor.set(-ClimbConstants.climbMotorSpeed);
  }

  public void stopMotor() {
    climbMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
