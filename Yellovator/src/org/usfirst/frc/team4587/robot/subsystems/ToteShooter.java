package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToteShooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final SpeedController Tote_Score_Motor;
	private final DigitalInput Tote_In, Tote_Out;
	 public ToteShooter()
	 {
		 Tote_Score_Motor = new Talon(RobotMap.MOTOR_DEPLOY_TOTES);
		 Tote_In = new DigitalInput(RobotMap.TOUCH_SENSOR_IN);
		 Tote_Out = new DigitalInput(RobotMap.TOUCH_SENSOR_OUT);
	 }
	 /**
	  * makes the deployer move until limit switch is active
	  */
	 public void Deploy(){
		 while(getTote_out() == false)
		 {
			 this.setDeployMotors(.6);
		 }
		 this.setDeployMotors(0);
	 }
	 /**
	  * hehe makes the deployer move until limit switch is active
	  */
	 public void Employ(){
		 while(getTote_in() == false)
		 {
			 this.setDeployMotors(-.6);
		 }
		 this.setDeployMotors(0);
	 }
	 /**
	  * set deployer motors
	  * @param power
	  */
	 public void setDeployMotors(double power)
	 {
		 this.Tote_Score_Motor.set(power);
	 }
	 /**
	  * Get limit switch value to see if tote deployer is in.
	  * @return
	  */
	 public boolean getTote_in(){
		 return this.Tote_In.get();
	 }
	 /**
	  * Get limit switch value to see if tote deployer is out.
	  * @return
	  */
	 public boolean getTote_out(){
		 return this.Tote_Out.get();
	 }
	 public void displayDeployer()
	 {
		 SmartDashboard.putBoolean("Is deployed?", getTote_out());
	 }
    public void initDefaultCommand() {}
   
}

