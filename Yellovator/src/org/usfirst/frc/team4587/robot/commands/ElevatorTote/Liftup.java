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
    		
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.liftertotes.brakeRelease();
    	Robot.liftertotes.moveElevator(.8);
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
    	Robot.liftertotes.moveElevator(0);//turn off motor
    	Robot.liftertotes.brakeSet();//set brakes
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	if(isFinished()) end();//make sure that the lift is interrupted.
    }
}
