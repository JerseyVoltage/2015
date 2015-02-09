package org.usfirst.frc.team4587.robot;

import org.usfirst.frc.team4587.robot.Util.F310GamePad;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4587.robot.commands.ElevatorTote.Liftdown;
import org.usfirst.frc.team4587.robot.commands.ElevatorTote.SetElevator;
import org.usfirst.frc.team4587.robot.commands.Shifter.*;
import org.usfirst.frc.team4587.robot.commands.TotesCollection.ToteIntake;
import org.usfirst.frc.team4587.robot.commands.TotesCollection.ToteOutake;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	public static F310GamePad driveStick = new F310GamePad(RobotMap.JOY_LEFT_PORT);
	public static F310GamePad operatorStick = new F310GamePad(RobotMap.JOY_RIGHT_PORT);
	public static final Button ShiftGears = new JoystickButton(driveStick,F310GamePad.button_Y);
	public static final Button Outake = new JoystickButton(driveStick,F310GamePad.button_L_Shoulder);
	public static final Button Intake = new JoystickButton(driveStick, F310GamePad.button_R_Shoulder);
	// operators controls
	public static final Button Position0 = new JoystickButton(operatorStick, F310GamePad.button_Start);
	public static final Button Position1 = new JoystickButton(operatorStick,F310GamePad.button_A);
	public static final Button Position2 = new JoystickButton(operatorStick, F310GamePad.button_B);
	public static final Button Position3 = new JoystickButton(operatorStick, F310GamePad.button_Y);
	public static final Button Position4 = new JoystickButton(operatorStick, F310GamePad.button_X);
	public static final Button liftTote = new JoystickButton(operatorStick, F310GamePad.button_L_Shoulder);
	public static final Button lowerTote = new JoystickButton(operatorStick, F310GamePad.button_R_Shoulder);
	
	
	public OI() { 
		ShiftGears.toggleWhenPressed(new ShiftGears());
		Outake.whileHeld(new ToteOutake());
		Intake.whileHeld(new ToteIntake());
		Position0.whenPressed(new SetElevator(Constants.FLOOR));
		Position1.whenPressed(new SetElevator(Constants.ONE_TOTE));
		Position2.whenPressed(new SetElevator(Constants.TWO_TOTE));
		Position3.whenPressed(new SetElevator(Constants.THREE_TOTE));
		Position4.whenPressed(new SetElevator(Constants.FOUR_TOTE));
		lowerTote.whileHeld(new Liftdown());
		liftTote.whileHeld(new Liftdown());
		
		
		}

}
