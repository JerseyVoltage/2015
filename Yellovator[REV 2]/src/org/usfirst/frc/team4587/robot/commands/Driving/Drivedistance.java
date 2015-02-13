package org.usfirst.frc.team4587.robot.commands.Driving;

import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drivedistance extends Command {
	double distance, power;

	/**
	 * 
	 * Drive in inches.
	 * 
	 * @param distance
	 * @param power
	 */
	public Drivedistance(double distance, double power) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.Drivetrain);
		this.distance = distance;
		this.power = power;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.Drivetrain.clearEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.Drivetrain.driveDistance_Enc(distance, power);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.Drivetrain.getAverageEncoders() >= distance;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.Drivetrain.stopDriveMotors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
