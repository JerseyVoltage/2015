package org.usfirst.frc.team4587.robot;

import org.usfirst.frc.team4587.robot.subsystems.DriveBase;
import org.usfirst.frc.team4587.robot.subsystems.ElevatorTote;
import org.usfirst.frc.team4587.robot.subsystems.Intaketotes;
import org.usfirst.frc.team4587.robot.subsystems.Shifter;
import org.usfirst.frc.team4587.robot.subsystems.ToteShooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public static OI oi;
	public static final DriveBase Drivetrain = new DriveBase();
	public static Shifter shiftspeed = new Shifter();
	public static Intaketotes Collection = new Intaketotes();
	public static ElevatorTote liftertotes = new ElevatorTote();
	public static ToteShooter scorertotes = new ToteShooter();
	public void robotInit() {
		oi = new OI();
		// Drivetrain.resetEncoders();
		System.out.println("init");

		// instantiate the command used for the autonomous period
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		liftertotes.display_Tote_Elevator();
		Drivetrain.displayDrive();

	}

	/**
	 * s This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
