package org.usfirst.frc.team4587.robot.subsystems;


import org.usfirst.frc.team4587.robot.RobotMap;
import org.usfirst.frc.team4587.robot.commands.Driving.ArcadeDrive;

import edu.wpi.first.wpilibj.Encoder;
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
Encoder rightEncoder, leftEncoder;	

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
    rightEncoder = new Encoder(RobotMap.ENCODER_SENSOR_R_A, RobotMap.ENCODER_SENSOR_R_B);
    leftEncoder = new Encoder(RobotMap.ENCODER_SENSOR_L_A, RobotMap.ENCODER_SENSOR_L_B);
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
		
		mDrive.arcadeDrive(move, rotate, true);
		H_wheel.set(strafe);
	
		
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
	public int getRightEncoder()
	{
		return rightEncoder.get();
	}
	public int getLeftEncoder()
	{
		return leftEncoder.get();
	}
	public double getAverageEncoders()
	{
		return Math.abs(getLeftEncoder() + getRightEncoder()/2);
	}
	

	public void displayDrive()
	{
		SmartDashboard.putNumber("Encoder Left", getLeftEncoder());
		SmartDashboard.putNumber("Encoder Right", getRightEncoder());
		SmartDashboard.putNumber("Average Ticks", getAverageEncoders());
	}

}

