package org.usfirst.frc.team4587.robot.commands.TotesCollection;

import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToteOutake extends Command {

	public ToteOutake() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.Collection);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("Intakes are Outaking");
		Robot.Collection.intakeOut();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.Collection.intakeOff();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
