package org.usfirst.frc.team4587.robot.commands.Driving;

import org.usfirst.frc.team4587.robot.OI;
import org.usfirst.frc.team4587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArcadeDrive extends Command {
private static final double deadBand = 1;
    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Drivetrain);
    }
// Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double triggers = OI.driveStick.getOldTriggers();
    	double move = OI.driveStick.getLeftJoystickY();
    	double rotate = OI.driveStick.getRightJoystickX();
    	double translation = OI.driveStick.getLeftJoystickX();
    	Robot.Drivetrain.holoDrive(move,rotate,translation);
    	
    	SmartDashboard.putNumber("H Motor value" , translation);
    	SmartDashboard.putNumber("Move" , move);
    	SmartDashboard.putNumber("Rotate" , rotate);
    	
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
