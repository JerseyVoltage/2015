package org.usfirst.frc.team4587.robot.commands.TotesCollection;
import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToteIntake extends Command {
    public ToteIntake() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.Collection);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	  if(isFinished() == false)
    	  {
    		  Robot.Collection.intakeIn();
    		  System.out.println("Intakes are intaking");
    	  }
    	  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
      }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 if(Robot.Collection.getSwitch() == false)
         {
        	 return true;
         }
    	 else
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
