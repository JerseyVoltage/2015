package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
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
	private double offset;
	private double last_output = 0;
	DigitalInput downLimit, upLimit;
	// Initialize your subsystem here
	private static final double Kp = 100;
	private static final double Ki = 0;
	private static final double Kd = 0;

	public ElevatorTote() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		super("Elevator", Kp, Ki, Kd);
		this.setAbsoluteTolerance(.002);
		this.getPIDController().setContinuous(false);
		this.offset = pot.get();
		
		// 
		pot = new AnalogPotentiometer(RobotMap.POT_SENSOR_LIFT, 1, 0); // pot
		downLimit = new DigitalInput(RobotMap.TOUCH_SENSOR_TD); // Down bumper switch
		upLimit = new DigitalInput(RobotMap.TOUCHSENSOR_TU); // up bumper sensor
		motorLift1 = new Talon(RobotMap.MOTOR_LIFT_TL1);// motor
		motorLift2 = new Talon(RobotMap.MOTOR_LIFT_TR1);//motor
		pistonBrake = new Solenoid(RobotMap.BRAKE_TOTE_ELEVATOR); //<----- probably not going to use
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return getPot();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		last_output = output;
		motorLift1.pidWrite(output);
		motorLift2.pidWrite(output);
	}

	public double getPot() {
		return pot.get() - offset;
	}

	public double updateOffset() {
		return offset = pot.get();
	}

	public void displayElevator() {
		SmartDashboard.putNumber("Pot Value", this.getPot());
		SmartDashboard.putNumber("OFFSET", offset);
		SmartDashboard.putNumber("Set Point", this.getSetpoint());
		SmartDashboard.putBoolean("PID ENABLED?", this.getPIDController()
				.isEnable());
		SmartDashboard.putBoolean("On Target", this.onTarget());
		SmartDashboard.putNumber("Lift Motors PID", last_output);
		SmartDashboard.putNumber("Lift MOtor Value", motorLift1.get());
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

	public boolean getDownLimit() {
		return downLimit.get();
	}

	public boolean getUpLimit() {
		return upLimit.get();
	}

	/**
	 * Raise lift
	 * 
	 * @param power
	 */
	public void moveElevator(double power) {
		motorLift1.set(-power);
		motorLift2.set(-power);
	}

	public void StopMotors() {
		motorLift1.set(0);
		motorLift2.set(0);
	}

}