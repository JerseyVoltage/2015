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
public class Intaketotes extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final SpeedController intakeMotor1, intakeMotor2;
	private final DigitalInput limitSwitchL, limitSwitchR;

	public Intaketotes() {
		limitSwitchL = new DigitalInput(RobotMap.TOUCH_SENSOR_C1);
		limitSwitchR = new DigitalInput(RobotMap.TOUCH_SENSOR_C2);
		intakeMotor1 = new Talon(RobotMap.MOTOR_INTAKE_L1);
		intakeMotor2 = new Talon(RobotMap.MOTOR_INTAKE_R1);
	}

	public void setIntake(double speed) {
		intakeMotor1.set(-speed);
		intakeMotor2.set(speed);
		System.out.println("motors with power level: " + speed);
	}
	/**
	 * Set eachmotor to different speeds
	 * @param speed1
	 * @param speed2
	 */
	public void setOneMotor(double speed1, double speed2){
		intakeMotor1.set(-speed1);
		intakeMotor2.set(speed2);
	} 

	public void intakeOff() {
		setIntake(0);
		System.out.println("Intakes OFF");
	}

	public void intakeOut() {
		setIntake(.8);
	}

	public void intakeIn() {
		setIntake(-.8);
	}

	public boolean getSwitchR() {
		return this.limitSwitchR.get();
	}
	
	public boolean getSwitchL(){
		return this.limitSwitchL.get();
	}
	public void displayIntake()
	{
		SmartDashboard.putBoolean("Switch Left L", getSwitchL());
		SmartDashboard.putBoolean("Switch Left R", getSwitchR());
		SmartDashboard.putNumber("Intake value", intakeMotor1.get());
		
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}
