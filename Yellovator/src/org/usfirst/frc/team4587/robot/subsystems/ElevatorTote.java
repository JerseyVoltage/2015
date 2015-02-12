package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorTote extends PIDSubsystem {
	Potentiometer pot;
	SpeedController motorLift1, motorLift2;
	Solenoid pistonBrake;
	private boolean brake;
	private double last_output = 0;
	// Initialize your subsystem here
	private static final double Kp = 5;
	private static final double Ki = 0;
	private static final double Kd = 0;

	public ElevatorTote() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		super("Elevator", Kp, Ki, Kd);
		this.setAbsoluteTolerance(.02);
		this.getPIDController().setContinuous(false);
		pot = new AnalogPotentiometer(RobotMap.POT_SENSOR_LIFT, 1, 0);
		motorLift1 = new Talon(RobotMap.MOTOR_LIFT_TL1);
		motorLift2 = new Talon(RobotMap.MOTOR_LIFT_TR1);
		pistonBrake = new Solenoid(RobotMap.BRAKE_TOTE_ELEVATOR);
		this.setSetpoint(pot.get());
		pistonBrake.set(brake);
		// brakeSet();

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		return pot.get();

	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		last_output = output;
		if (this.onTarget() == true) {
			motorLift1.pidWrite(0);
			motorLift2.pidWrite(0);
			// brakeSet();
		} else if (brake == true) {
			// brakeRelease();
			// Place to extend time of loop
		} else {
			motorLift1.pidWrite(output);
			motorLift2.pidWrite(output);
		}

	}

	public void display_Tote_Elevator() {
		SmartDashboard.putNumber("Pot Value", pot.get());
		SmartDashboard.putNumber("Set Point", this.getSetpoint());
		SmartDashboard.putBoolean("Brake", brake);
		SmartDashboard.putBoolean("On Target", this.onTarget());
		SmartDashboard.putNumber("Lift Motors PID", last_output);
		SmartDashboard.putNumber("Lift Motor Value", motorLift1.get());
	}

	/**
	 * Tote Elevator brake set engage
	 */
	public void brakeRelease() {
		brake = false;
		this.pistonBrake.set(brake);
	}

	public void brakeSet() {
		brake = true;
		this.pistonBrake.set(brake);
	}

	/**
	 * Raise lift
	 * 
	 * @param power
	 */
	public void moveElevator(double power) {
		motorLift1.set(power);
		motorLift2.set(power);
	}

	public void StopMotors() {
		motorLift1.set(0);
		motorLift2.set(0);
	}

}