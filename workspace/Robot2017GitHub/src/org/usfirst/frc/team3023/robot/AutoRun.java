package org.usfirst.frc.team3023.robot;

import org.usfirst.frc.team3023.robot.commands.AutoTimeDriving;
import org.usfirst.frc.team3023.robot.commands.IRAutoDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRun extends CommandGroup {

	int PegLoc; int LineCross; int Direction;
	
	
public AutoRun(int pg, int lc, int dr){
	PegLoc = pg; LineCross = lc; /* 1 is Left, 0 is Right */ Direction = dr;
	
	//Still need right times and volts
	
	if(PegLoc == 1){addSequential(new IRAutoDrive((float) .75, (float) .75));}
	
	if(PegLoc == 2 && LineCross == 0){addSequential(new IRAutoDrive((float) .75, (float) .75));}
	
	if(PegLoc == 2 && LineCross == 1 && Direction == 1){addSequential(new IRAutoDrive((float) .75, (float) .75));
	/* Turn Left 90 */ addSequential(new AutoTimeDriving((float) -.5, (float) .5, (float) .5));
	/* Go Left */ addSequential(new AutoTimeDriving((float) .75,(float) .75,(float) 3));
	/* Turn Right 90 */ addSequential(new AutoTimeDriving((float) .5, (float) -.5, (float) .5));
	/* Go Forward */ addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 3));}
	
	if(PegLoc == 2 && LineCross == 1 && Direction == 0){addSequential(new IRAutoDrive((float) .75, (float) .75));
	/* Turn Right 90 */ addSequential(new AutoTimeDriving((float) .5, (float) -.5, (float) .5));
	/* Go Right */ addSequential(new AutoTimeDriving((float) .75,(float) .75,(float) 3));
	/* Turn Left 90 */ addSequential(new AutoTimeDriving((float) -.5, (float) .5, (float) .5));
	/* Go Forward */ addSequential(new AutoTimeDriving((float) .75, (float) .75, (float) 3));}
	
	if(PegLoc == 3){addSequential(new IRAutoDrive((float) .75, (float) .75));}}
}