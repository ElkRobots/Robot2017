package org.usfirst.frc.team3023.robot;

import org.usfirst.frc.team3023.robot.commands.CamSwitch;
import org.usfirst.frc.team3023.robot.commands.AutoIRDriving;
import org.usfirst.frc.team3023.robot.commands.AutoTimeDriving;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRun extends CommandGroup {

	public AutoRun(int pegloc, boolean linecross, boolean left, boolean right) {
		/* 1 is Left, 0 is Right */
		
		System.out.println("pegloc: " + pegloc);
		System.out.println("linecross: " + linecross);
		System.out.println("left: " + left);
		System.out.println("right: " + right);


//		// Still need right times and volts
//		// Get Auto times with stopwatch, full joystick @ 50%, exact distance
//		if (pegloc == 0) {
//			addSequential(new AutoTimeDriving(0, 0, 600));
//		}
//
//		if (pegloc == 1) {
//			addSequential(new AutoIRDriving(.75, .75));
//			//addSequential(new CamSwitch());
//		}
//		if (pegloc == 2 && !linecross) {
//			addSequential(new AutoIRDriving(.75, .75));
//			//addSequential(new CamSwitch());
//		}
//
//		if (pegloc == 2 && linecross && left) {
//			addSequential(new AutoIRDriving(.75, .75));
//			/* Run Cam Tracking */ addSequential(new CamSwitch());
//			/* Turn Left 90 */ addSequential(new AutoTimeDriving(-.5, .5, .5));
//			/* Go Left */ addSequential(new AutoTimeDriving(.75, .75, 3));
//			/* Turn Right 90 */ addSequential(new AutoTimeDriving(.5, -.5, .5));
//			/* Go Forward */ addSequential(new AutoTimeDriving(.75, .75, 3));
//			
//		}
//
//		if (pegloc == 2 && linecross && right) {
//			addSequential(new AutoIRDriving(.75, .75));
//			/* Run Cam Tracking */ addSequential(new CamSwitch());
//			/* Turn Right 90 */ addSequential(new AutoTimeDriving(.5, -.5, .5));
//			/* Go Right */ addSequential(new AutoTimeDriving(.75, .75, 3));
//			/* Turn Left 90 */ addSequential(new AutoTimeDriving(-.5, .5, .5));
//			/* Go Forward */ addSequential(new AutoTimeDriving(.75, .75, 3));
//		}
//
//		if (pegloc == 3) {
//			addSequential(new AutoIRDriving(.75, .75));
//			//addSequential(new CamSwitch());
//		}

	}
}