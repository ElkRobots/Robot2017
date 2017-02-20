package org.usfirst.frc.team3023.robot;

import org.usfirst.frc.team3023.robot.commands.AutoTimeDriving;
import org.usfirst.frc.team3023.robot.commands.CamSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRun extends CommandGroup {
	
public AutoRun(int pegloc, boolean linecross, boolean left, boolean right){
	 /* 1 is Left, 0 is Right */
	
	//Still need right times and volts
	//Get Auto times with stopwatch, full joystick @ 50%, exact distance
	if(pegloc == 0){addSequential(new AutoTimeDriving((float) 0,(float) 0,(float) 600));}
	
	if(pegloc == 1){addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 15));
					addSequential(new CamSwitch(true, true));}
	
	if(pegloc == 2 && !linecross){addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 3));
									  addSequential(new CamSwitch(true, true));}
	
	if(pegloc == 2 && linecross && left){addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 13));
	/* Turn Cam On*/ addSequential(new CamSwitch(true, true)); if(Robot.oi.GearDone){
	/* Turn Left 90 */ addSequential(new AutoTimeDriving((float) -.5, (float) .5, (float) .5));
	/* Go Left */ addSequential(new AutoTimeDriving((float) .75,(float) .75,(float) 3));
	/* Turn Right 90 */ addSequential(new AutoTimeDriving((float) .5, (float) -.5, (float) .5));
	/* Go Forward */ addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 3));}}
	
	if(pegloc == 2 && linecross && right){addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 13));
	/* Turn Cam On*/ addSequential(new CamSwitch(true, true)); if(Robot.oi.GearDone){
	/* Turn Right 90 */ addSequential(new AutoTimeDriving((float) .5, (float) -.5, (float) .5));
	/* Go Right */ addSequential(new AutoTimeDriving((float) .75,(float) .75,(float) 3));
	/* Turn Left 90 */ addSequential(new AutoTimeDriving((float) -.5, (float) .5, (float) .5));
	/* Go Forward */ addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 3));}}
	
	if(pegloc == 3){addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 15));
					addSequential((new CamSwitch(true, true)));}}

}