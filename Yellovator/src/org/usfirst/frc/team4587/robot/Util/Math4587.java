package org.usfirst.frc.team4587.robot.Util;

public class Math4587 {
	/*
	 * Change these value once we get the actual results
	 */
	 private static final int ENCODER_TICKS_PER_ROTATION = 360;
	 private static final double DRIVE_RATIO = 1; //gear ratio
	 private static final double WHEEL_SIZE = 4; // current wheel is 4 inches
	 /**
	  * Measure how far we travel using encoders
	  * @param Encoder
	  * @param gearRatio
	  * @param wheelSize
	  * @return
	  */
	public static double distanceTravelled_Inches(double Encoder){
		return Math.abs(Encoder * ((WHEEL_SIZE * DRIVE_RATIO)*Math.PI)/ENCODER_TICKS_PER_ROTATION);
	}
	
	/*
	 * Change these value once we get the actual results
	 */
	private static final double POT_VOLTAGE_PER_ROTATION = 100;
	private static final double POT_RATIO = 0.5;//Gear ratio
	private static final double POT_DIAMTER = 0.5;
	/**
	 * Insert Pot get pot voltage
	 * @param pot
	 * @return
	 */
	public static double getPotHeight_Inches(double pot)
	{
		return (pot *(POT_DIAMTER * POT_RATIO) * Math.PI)/POT_VOLTAGE_PER_ROTATION;
	}
	/**
	 * Make sure the value is within a certain threshold.
	 * @param current
	 * @param lower
	 * @param upper
	 * @return
	 */
	public static boolean withinThreshold(double current, double lower, double upper)
	{
		if(current > lower && current < upper){
			return true;
		}
		else 
			return false;
	}
	
}
