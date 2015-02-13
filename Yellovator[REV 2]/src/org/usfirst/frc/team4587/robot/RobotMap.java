package org.usfirst.frc.team4587.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// ///////////////////////////--PWMS--/////////////////////////////////////////////////////
	/*
	 * Motors Left side Drive
	 */
	public static final int MOTOR_DRIVE_L1 = 0;
	public static final int MOTOR_DRIVE_L2 = 1;
	/*
	 * Motors Right Side
	 */
	public static final int MOTOR_DRIVE_R1 = 2;
	public static final int MOTOR_DRIVE_R2 = 3;

	/*
	 * H drive motors
	 */
	public static final int MOTOR_DRIVE_H = 4;
	/*
	 * Intake Motors
	 */
	public static final int MOTOR_INTAKE_L1 = 5;
	public static final int MOTOR_INTAKE_R1 = 6;
	/*
	 * Elevator Motors for totes
	 */
	public static final int MOTOR_LIFT_TL1 = 7;
	public static final int MOTOR_LIFT_TR1 = 8;
	/*
	 * Elevator Motors for Can
	 */
	public static final int MOTOR_LIFT_C1 = 9;
	/*
	 * Motor to deploy totes
	 */
	public static final int MOTOR_DEPLOY_TOTES = 10;
	// ////////////////////////////////--Solenoids--/////////////////////////////////////////

	/*
	 * Collector Pneumatics for totes
	 */
	public static final int BRAKE_TOTE_ELEVATOR = 1;
	public static final int BRAKE_CAN_ELEVATOR = 2;
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

	// /////////////////////////////////--DIO--///////////////////////////////////////////////////
	/*
	 * Touch Sensors for Totes collection
	 */
	public static final int TOUCH_SENSOR_C1 = 0; // left
	public static final int TOUCH_SENSOR_C2 = 1; // right
	/*
	 * Touch Sensor for deploying totes
	 */
	public static final int TOUCH_SENSOR_IN = 2;
	public static final int TOUCH_SENSOR_OUT = 3;
	/*
	 * Encoders for Drive Wheels Two ports: a,b
	 */
	public static final int ENCODER_SENSOR_R_A = 4;
	public static final int ENCODER_SENSOR_R_B = 5;
	// LEFT SIDE
	public static final int ENCODER_SENSOR_L_A = 6;
	public static final int ENCODER_SENSOR_L_B = 7;
	/*
	 * Touch sensor for Elevator tote
	 */
	public static final int TOUCH_SENSOR_TD = 8; //down touch sensor
	public static final int TOUCHSENSOR_TU = 9;
	// //////////////////////////////////--Analog--///////////////////////////////
	/*
	 * Pot... so we can measure how high we are.... hehe
	 */
	public static final int POT_SENSOR_LIFT = 1;
	// //////////////////////////////////--Controls--/////////////////////////////////////////
	/**
	 * The port the right joystick is plugged into.
	 */
	public static final int JOY_RIGHT_PORT = 0;
	/**
	 * The port the left joystick is plugged into.
	 */
	public static final int JOY_LEFT_PORT = 1;
	/**
	 * The port for TI launchpad
	 */
	public static final int TI_LAUNCH_PAD = 2;
}