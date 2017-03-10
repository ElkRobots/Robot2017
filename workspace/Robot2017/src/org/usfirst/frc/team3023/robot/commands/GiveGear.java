
package org.usfirst.frc.team3023.robot.commands;

import org.usfirst.frc.team3023.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GiveGear extends CommandGroup {

    public GiveGear() {
     
    	addParallel(new Print("Placing Gear..."));
    	addSequential(new MoveGearTimed(1, 1.5));
    	addParallel(new AutoTimeDriving(-.25, -.25, .5));
    	addSequential(new MoveGearTimed(-1, 1.5));
    	addParallel(new Print("Reseting Gear Handler..."));
    	addSequential(new HorizontalReset(Robot.ds.HorTime.get()));}
    
    protected void initialize(){Robot.cs.ThreadSleep(0);}
    	
    private class Print extends Command{String ln;
    	private Print(String ln) {ln=this.ln;}
    	protected void execute() {System.out.println(ln);}
    	@Override
		protected boolean isFinished() {return true;}}
}