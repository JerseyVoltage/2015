package org.usfirst.frc.team4587.robot;

import org.usfirst.frc.team4587.robot.Util.Dpad;
import org.usfirst.frc.team4587.robot.Util.F310GamePad;
import org.usfirst.frc.team4587.robot.Util.JoyButton;
import org.usfirst.frc.team4587.robot.Util.TIGamepad;
import org.usfirst.frc.team4587.robot.commands.ToteScorer;
import org.usfirst.frc.team4587.robot.commands.ElevatorTote.Liftdown;
import org.usfirst.frc.team4587.robot.commands.ElevatorTote.Liftup;
import org.usfirst.frc.team4587.robot.commands.ElevatorTote.Pickup;
import org.usfirst.frc.team4587.robot.commands.ElevatorTote.SetElevator;
import org.usfirst.frc.team4587.robot.commands.Shifter.ShiftGears;
import org.usfirst.frc.team4587.robot.commands.TotesCollection.ToteIntake;
import org.usfirst.frc.team4587.robot.commands.TotesCollection.ToteOutake;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Controllers
	public static F310GamePad driveStick = new F310GamePad(RobotMap.JOY_LEFT_PORT);
	public static F310GamePad operatorStick = new F310GamePad(RobotMap.JOY_RIGHT_PORT);
	public static TIGamepad operatorPad = new TIGamepad(RobotMap.TI_LAUNCH_PAD);
	
	// Driver Controls
	public static final Button ShiftGears = new JoystickButton(driveStick,F310GamePad.button_Y);
	public static final Button Outake = new JoystickButton(driveStick,F310GamePad.button_L_Shoulder);
	public static final Button Intake = new JoystickButton(driveStick, F310GamePad.button_R_Shoulder);
	// operators controls
	public static final Button Position0 = new JoystickButton(operatorStick, F310GamePad.button_Start);
	public static final Button Position1 = new JoystickButton(operatorStick,F310GamePad.button_A);
	public static final Button Position2 = new JoystickButton(operatorStick, F310GamePad.button_B);
	public static final Button Position3 = new JoystickButton(operatorStick, F310GamePad.button_Y);
	public static final Button Position4 = new JoystickButton(operatorStick, F310GamePad.button_X);
	public static final Button Deployer = new JoystickButton(operatorStick, F310GamePad.button_Back);
	public static final JoyButton liftUp = new JoyButton(operatorStick,JoyButton.JoyDir.UP, F310GamePad.rightStick_Y);
	public static final JoyButton liftDown = new JoyButton(operatorStick, JoyButton.JoyDir.DOWN, F310GamePad.rightStick_Y);
	public static final Dpad pickuptote1 = new Dpad(operatorStick, Dpad.HatDir.DOWN);
	//public static final Button testButon = new JoystickButton(operatorPad, TIGamepad.button_pad_1);
	public OI() { 
		ShiftGears.toggleWhenPressed(new ShiftGears());
		Outake.whileHeld(new ToteOutake());
		Intake.whileHeld(new ToteIntake());
		Deployer.whileHeld(new ToteScorer());
		Position0.whenPressed(new SetElevator(Constants.FLOOR));
		Position1.whenPressed(new SetElevator(Constants.ONE_TOTE));
		Position2.whenPressed(new SetElevator(Constants.TWO_TOTE));
		Position3.whenPressed(new SetElevator(Constants.THREE_TOTE));
		Position4.whenPressed(new SetElevator(Constants.FOUR_TOTE));
		liftDown.whileHeld(new Liftdown(1));
		liftUp.whileHeld(new Liftup(1));
		pickuptote1.whenActive(new Pickup());
		//testButton.whileActive(command);
		}

}
