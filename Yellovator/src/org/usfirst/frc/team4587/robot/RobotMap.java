package org.usfirst.frc.team4587.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// ///////////////////////////PWMS/////////////////////////////////////////////////////
			/*
			 * Motors Left side Drive
			 */
			public static final int MOTOR_DRIVE_L1 = 0;
			public static final int MOTOR_DRIVE_L2 = 1;
			public static final int MOTOR_DRIVE_L3 = 2;
			/*
			 * Motors Right Side
			 */
			public static final int MOTOR_DRIVE_R1 = 3;
			public static final int MOTOR_DRIVE_R2 = 4;
			public static final int MOTOR_DRIVE_R3 = 5;
			/*
			 * H drive motors
			 */
			public static final int MOTOR_DRIVE_H = 6;
			/*
			 * Intake Motors
			 */
			public static final int MOTOR_INTAKE_L1 = 7;
			public static final int MOTOR_INTAKE_R1 = 8;
			/*
			 * Elevator Motors for totes
			 */
			public static final int MOTOR_LIFT_TL1 = 9;
			public static final int MOTOR_LIFT_TR1 = 10;
			/*
			 * Elevator Motors for Can
			 */
			public static final int MOTOR_LIFT_C1 = 11;

			// //////////////////////////////////Solenoids/////////////////////////////////////////

			/*
			 * Collector Pneumatics for totes
			 */
			public static final int INTAKE_SOLENOID_L1 = 1;
			public static final int INTAKE_SOLENOID_R2 = 2;
			/*
			 * Pneumatic Shifter for Drivetrain
			 */
			public static final int SHIFTER_SOLENOID_L1 = 3;
			public static final int SHIFTER_SOLENOID_R1 = 4;
			/*
			 * Claw Pneumatics for can
			 */
			public static final int CLAW_SOLENOID_1 = 5;
			/*
			 * Solenoid for Shifters
			 */
			// //////////////////////////////////--Relays--//////////////////////////////////////////

			/*
			 * Relay the Lights, LED is plugged into
			 */
			public static final int LIGHT_RELAY = 2;
			/*
			 * Relay the Compressor is plugged into
			 */
			public static final int COMPRESSOR_RELAY = 4;

			// //////////////////////////////////--Sensors
			// --/////////////////////////////////////////
			/*
			 * Touch Sensors for Totes
			 */
			public static final int TOUCH_SENSOR_L1 = 0;
			public static final int TOUCH_SENSOR_R1 = 2;
			/*
			 * Encoders for Drive Wheels Two ports: a,b
			 */
			public static final int ENCODER_SENSOR_R_A = 3;
			public static final int ENCODER_SENSOR_R_B = 4;
			// LEFT SIDE
			public static final int ENCODER_SENSOR_L_A = 5;
			public static final int ENCODER_SENSOR_L_B = 6;
			/*
			 * Pot... so we can measure how high we are.... hehe
			 */
			public static final int POT_SENSOR_LIFT = 1;
			// //////////////////////////////////--Controls // --/////////////////////////////////////////
			/**
			 * The port the right joystick is plugged into.
			 */
			public static final int JOY_RIGHT_PORT = 0;
			/**
			 * The port the left joystick is plugged into.
			 */
			public static final int JOY_LEFT_PORT = 1;
		
}