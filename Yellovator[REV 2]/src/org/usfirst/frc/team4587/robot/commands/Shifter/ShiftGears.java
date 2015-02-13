package org.usfirst.frc.team4587.robot.commands.Shifter;
import org.usfirst.frc.team4587.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class ShiftGears extends Command {

	  public ShiftGears() {
	        // Use requires() here to declare subsystem dependencies
	        // eg. requires(chassis);
	    	requires(Robot.shiftspeed);
	    	}
	    // Called just before this Command runs the first time
	    protected void initialize() {
	    Robot.shiftspeed.shiftSpeed();
	    // SmartDashboard.putNumber("Lance", 0);
	     System.out.println("Shifter Init");
	    }	

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	//SmartDashboard.putNumber("Lance", 15);
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
		     System.out.println("Shifter End");
		    Robot.shiftspeed.shiftTorque(); 
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    	end();
	    }
}
