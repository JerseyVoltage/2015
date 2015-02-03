package org.usfirst.frc.team4587.robot.subsystems;

import org.usfirst.frc.team4587.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorTote extends PIDSubsystem {
Potentiometer pot;
SpeedController motorLift1, motorLift2;
private boolean brake;
private double last_output = 0;
   private static final int Kp = 5;
   private static final int Ki = 5;
   private static final int Kd = 5;
    public ElevatorTote() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
		super("Elevator", Kp , Ki , Kd);
    	this.setAbsoluteTolerance(.02);
    	this.getPIDController().setContinuous(false);
    	pot = new AnalogPotentiometer(RobotMap.POT_SENSOR_LIFT, 1,0);
    	motorLift1 = new Talon(RobotMap.MOTOR_INTAKE_L1);
    	motorLift2 = new Talon(RobotMap.MOTOR_INTAKE_R1);
    	this.setSetpoint(pot.get());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	
    	return pot.get();
    	
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	last_output = output;
    	
    		motorLift1.pidWrite(output);
    		motorLift2.pidWrite(output);
    	
    	
    }
    public void display()
    {
    	SmartDashboard.putNumber("Pot Value", pot.get());
    	SmartDashboard.putNumber("Set Point", this.getSetpoint());
    	SmartDashboard.putBoolean("Brake", brake);
    	SmartDashboard.putBoolean("On Target", this.onTarget());
    	SmartDashboard.putNumber("Last Output", last_output);
    }
    public void brakeRelease() {
    	brake = false;
    }
    public void brakeSet() {
    	brake = true;
    }
}