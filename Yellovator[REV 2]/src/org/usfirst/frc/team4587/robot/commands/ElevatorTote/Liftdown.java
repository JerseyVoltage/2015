package org.usfirst.frc.team4587.robot.commands.ElevatorTote;

import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Liftdown extends Command {
	private double power;

	public Liftdown(double power) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.liftertotes);
		this.setInterruptible(false);// cant interrupt with pid lift system
		System.out.println("Lift down constructor");
		this.power = power;
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("Lift down Initialize");
		Robot.liftertotes.disable();
		Robot.liftertotes.moveElevator(-power);
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(Robot.liftertotes.getDownLimit())
		{
			Robot.liftertotes.updateOffset();
			Robot.liftertotes.disable();
			Robot.liftertotes.StopMotors();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("End lift down");
		//Robot.liftertotes.moveElevator(0);// turn off motor
		//Robot.liftertotes.brakeSet();// set brakes
		Robot.liftertotes.setSetpoint(Robot.liftertotes.getPosition());
		Robot.liftertotes.enable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("interrupted lift down ");
		end();
	}
}
