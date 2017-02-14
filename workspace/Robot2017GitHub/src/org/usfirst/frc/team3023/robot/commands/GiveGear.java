
package org.usfirst.frc.team3023.robot.commands;

import org.usfirst.frc.team3023.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GiveGear extends CommandGroup {

    public GiveGear() {
     
    	addSequential(new MoveGear((float) .25, 3));
    	addParallel(new AutoTimeDriving((float) -.25,(float) -.25,(float) .5));
    	addSequential(new MoveGear((float) -.25, 3));
    	addSequential(new HorizontalReset((float) Robot.ds.HorTime.get()));}
}