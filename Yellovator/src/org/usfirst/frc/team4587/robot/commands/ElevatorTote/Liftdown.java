package org.usfirst.frc.team4587.robot.commands.ElevatorTote;

import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Liftdown extends Command {

    public Liftdown() {
    	requires(Robot.liftertotes);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SetElevator.autoLift = false;
    	Robot.liftertotes.brakeRelease();
    	Robot.liftertotes.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(SetElevator.autoLift == false)
    	{
    		Robot.liftertotes.moveElevator(-.8);//move elevator down.
    	}
    	else{}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftertotes.brakeSet();
    	Robot.liftertotes.moveElevator(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
