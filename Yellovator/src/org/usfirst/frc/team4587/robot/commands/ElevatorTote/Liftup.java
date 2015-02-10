package org.usfirst.frc.team4587.robot.commands.ElevatorTote;

import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Liftup extends Command {

	public Liftup() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.liftertotes);
		 this.setInterruptible(false);// cant interrupt with pid lift system
		 System.out.println("Lift up constructor");
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("Lift up Initialize");
		Robot.liftertotes.brakeRelease();
		Robot.liftertotes.moveElevator(.3);
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
		System.out.println("End lift up");
		Robot.liftertotes.moveElevator(0);// turn off motor
		Robot.liftertotes.brakeSet();// set brakes
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("interrupted lift up ");
		end();
	}
}
