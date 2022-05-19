// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int driverJoystickID = 0;
    public static int operatorJoystickID = 1;

    public static final class DriveConstants {
        public static int frontLeftMotorID = 4;
        public static int frontRightMotorID = 1;
        public static int backLeftMotorID = 2;
        public static int backRightMotorID = 3;
    }

    public static final class ClimbConstants {
        public static int climbMotorID = 5;
        public static double climbMotorSpeed = 0.5;
    }

    public static final class Buttons {
        public static int climbButton = 5;
        public static int intakeButton = 14; 
        public static int outakeButton = 13; 
    }

    public static final class IntakeConstants {
        public static int intakeMotorID = 6;  
        public static int conveyorID = 7; 
        public static double intakeSpeed = 0.5; 
    }
}
