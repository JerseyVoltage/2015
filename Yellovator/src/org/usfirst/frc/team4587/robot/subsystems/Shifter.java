package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
    
	 // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid Piston;
	private boolean mode = false;
	public Shifter()
	{
	 	Piston = new Solenoid(RobotMap.SHIFTER_SOLENOID_L1);
	 	Piston.set(mode);
	 }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void shiftSpeed(){
	    System.out.println("Shifter speed");
    	mode = false;
    	Piston.set(mode);
    }
    public void shiftTorque(){
	    System.out.println("Shifter torque");
    	mode = true;
    	Piston.set(mode);
    }
}

