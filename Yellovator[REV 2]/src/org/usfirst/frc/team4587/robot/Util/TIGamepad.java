package org.usfirst.frc.team4587.robot.Util;

import edu.wpi.first.wpilibj.Joystick;

public class TIGamepad extends Joystick{
	// boolean buttons:
		public static final int button_pad_1 = 1;
		public static final int button_pad_2 = 2;
		public static final int button_pad_3 = 3;
		public static final int button_pad_4 = 4;
		public static final int button_pad_5 = 5;
		public static final int button_pad_6 = 6;
		public static final int button_pad_7 = 7;
		public static final int button_pad_8 = 8;
		public static final int button_pad_9 = 9;
		public static final int button_pad_10 = 10;
		int port;
	public TIGamepad(int port) {
		super(port);
		this.port = port;
		// TODO Auto-generated constructor stub
	}
	
}