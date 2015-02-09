package org.usfirst.frc.team4587.robot.commands.ElevatorTote;

import org.usfirst.frc.team4587.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetElevator extends Command {
private double TotePosition;
public static Boolean autoLift;
    public SetElevator(double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftertotes);
    	this.TotePosition = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	autoLift = true;
    	Robot.liftertotes.setSetpoint(TotePosition);
    	Robot.liftertotes.enable();
    	Robot.liftertotes.brakeRelease();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(autoLift == true){}
    	else autoLift = false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.liftertotes.onTarget() || autoLift == false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.liftertotes.disable();
    	//Robot.liftertotes.stop();
    	Robot.liftertotes.brakeSet();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
