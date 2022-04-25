// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax frontLeftMotor = new CANSparkMax(DriveConstants.frontLeftMotorID, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(DriveConstants.backLeftMotorID, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(DriveConstants.frontRightMotorID, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(DriveConstants.backRightMotorID, MotorType.kBrushless);

  private MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private MotorControllerGroup rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);

  private RelativeEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
  private RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();
  private RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
  private RelativeEncoder backRightEncoder = backRightMotor.getEncoder();

  private DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  BangBangController bbController = new BangBangController();

  SlewRateLimiter slewFilter = new SlewRateLimiter(1.0);


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
  }

  public void manualDrive(double forward, double turn) {
    slewFilter.calculate(1.0);

    differentialDrive.arcadeDrive(slewFilter.calculate(forward), turn);

    //double setpoint = 1.0; //there will be one for each motor
    //double frontLeftDistance = setpoint - frontLeftEncoder.getPosition();
    //frontLeftMotor.set(bbController.calculate(frontLeftDistance, setpoint));
    //double backLeftDistance = setpoint - backLeftEncoder.getPosition();
    //backLeftMotor.set(bbController.calculate(backLeftDistance, setpoint));
    //double frontRightDistance = setpoint - frontRightEncoder.getPosition();
    //frontRightMotor.set(bbController.calculate(frontRightDistance, setpoint));
    //double backRightDistance = setpoint - backRightEncoder.getPosition();
    //backRightMotor.set(bbController.calculate(backRightDistance, setpoint));
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
