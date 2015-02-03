package org.usfirst.frc.team4587.robot.subsystems;


import org.usfirst.frc.team4587.robot.RobotMap;
import org.usfirst.frc.team4587.robot.commands.Driving.ArcadeDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;		
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveBase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
SpeedController left1,left2,right1,right2 , H_wheel;
Gyro gyro;
private static final double deadBand = .1;
private final RobotDrive mDrive;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
      setDefaultCommand(new ArcadeDrive());
    }
/*
 * Constructor for Drivetrain
 */
    public DriveBase() 
    {
    	gyro = new Gyro(RobotMap.GYRO_SENSOR);
	mDrive = new RobotDrive(RobotMap.MOTOR_DRIVE_L1,RobotMap.MOTOR_DRIVE_L2,RobotMap.MOTOR_DRIVE_R1,RobotMap.MOTOR_DRIVE_R2);
	H_wheel = new Talon(RobotMap.MOTOR_DRIVE_H);
	}
	/**
	 * Arcade Drive get y, get x
	 * @param move
	 * @param rotate
	 */
	public void holoDrive(double move, double rotate, double strafe)
	{
		mDrive.arcadeDrive(move, rotate);
		H_wheel.set(strafe);
	}
	  
	    /**
	     * 
	     * @param move
	     * @param rotate
	     * @param strafe
	     * @param current_Angle
	     * @param Button
	     */
		public void holodrive(double move, double rotate, double current_Angle, boolean Button) 
		{
			double rotationClockwise;
			double speed = Math.max(Math.abs(move), Math.abs(rotate));
			double direction = Math.atan2(move,-rotate)*(180/2);
			double angleError = direction - current_Angle;
			while(angleError >  180)
			{
				angleError-=360;
			}
			while(angleError < -180)
			{
				angleError+=360;
			}
			if(!Button)//If you want to turn the robot the long way.
			{
				if(angleError > 100)//adjust variable as needed
				{
					angleError-=180;
					speed = -speed;
				}
				else if(angleError < -100)
				{
					angleError +=180;
					speed = -speed;
				}
			}
			if(Math.abs(speed)< deadBand)
			{
				rotationClockwise = 0;
			}
			rotationClockwise = angleError/45;
			double leftSpeed = 	(speed + rotationClockwise);
			double rightSpeed = (speed - rotationClockwise);
			left1.set(leftSpeed);
			left2.set(leftSpeed);
			right1.set(rightSpeed);
			right2.set(rightSpeed);
		}

	public void setMotors(double power)
	{
		left1.set(power);
		left2.set(power);
		right1.set(power);
		right2.set(power);
	}
	
	public void setHMotor(double power)
	
	{
		this.H_wheel.set(power);
		
	}
	public void displayDrive()
	{
		SmartDashboard.putNumber("H Motor value" , H_wheel.get());
		SmartDashboard.putNumber("Left1", left1.get());
		SmartDashboard.putNumber("Left2", left2.get());
		SmartDashboard.putNumber("right1", right1.get());
		SmartDashboard.putNumber("right2", right2.get());
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
		
	}

}

