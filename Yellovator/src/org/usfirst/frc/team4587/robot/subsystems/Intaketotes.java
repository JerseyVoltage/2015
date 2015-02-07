package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intaketotes extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
private final SpeedController intakeMotor1, intakeMotor2;
private final DigitalInput limitSwitch;
public Intaketotes(){
	limitSwitch = new DigitalInput(RobotMap.TOUCH_SENSOR_L1);
	intakeMotor1 = new Talon(RobotMap.MOTOR_INTAKE_L1);
	intakeMotor2 = new Talon(RobotMap.MOTOR_INTAKE_R1);
}
public void setIntake(double speed)
{
  intakeMotor1.set(-speed);	
  intakeMotor2.set(speed);
  System.out.println("motors with power level: " + speed);
}
public void intakeOff()
{
	setIntake(0);	
   System.out.println("Intakes OFF");
}
public void intakeOut()
{
  setIntake(.8);
}
public void intakeIn()
{
  setIntake(-.8);
}
public boolean getSwitch()
{
  return this.limitSwitch.get();	
}
public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
}

}

