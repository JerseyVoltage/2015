package org.usfirst.frc.team4587.robot.Util;

import edu.wpi.first.wpilibj.Joystick;

public class F310GamePad extends Joystick {

	public static final int leftStick_X = 0;
	public static final int leftStick_Y = 1;
	public static final int shoulderAxis_R = 2;
	public static final int shoulderAxis_L = 3;
	public static final int rightStick_X = 4;
	public static final int rightStick_Y = 5;
	public static final int dpadAxis = 6;

	// boolean buttons:
	public static final int button_A = 1;
	public static final int button_B = 2;
	public static final int button_X = 3;
	public static final int button_Y = 4;
	public static final int button_L_Shoulder = 5;
	public static final int button_R_Shoulder = 6;
	public static final int button_Back = 7;
	public static final int button_Start = 8;
	public static final int button_LeftStick = 9;
	public static final int button_RightStick = 10;

	public static final double deadZone = .2;
	int port;

	/**
	 * Creates a gamepad attached to the specified port on the driver station.
	 * 
	 * @param port
	 */
	public F310GamePad(int port) {
		super(port);
		this.port = port;
	}

	public double getLeftJoystickX() {
		if (Math.abs(getRawAxis(leftStick_X)) > deadZone) {
			return this.getRawAxis(leftStick_X);
		} else
			return 0.0;
	}

	public double getLeftJoystickY() {
		if (Math.abs(getRawAxis(leftStick_Y)) > deadZone) {
			return this.getRawAxis(leftStick_Y);
		} else
			return 0.0;

	}

	public double getRightJoystickX() {
		if (Math.abs(getRawAxis(rightStick_X)) > deadZone) {
			return this.getRawAxis(rightStick_X);
		} else
			return 0.0;
	}

	public double getRightJoysickY() {
		if (Math.abs(getRawAxis(rightStick_Y)) > deadZone) {
			return this.getRawAxis(rightStick_Y);
		} else
			return 0.0;

	}

	public double getRightTrigger() {
		return this.getRawAxis(shoulderAxis_R);
	}

	public double getLeftTrigger() {
		return this.getRawAxis(shoulderAxis_L);
	}

	public double getOldTriggers() {
		return -getRightTrigger() + getLeftTrigger();
	}

	public boolean getButton(int button) {
		return this.getRawButton(button);
	}

	public double getDpad() {
		return this.getPOV();
	}

}
