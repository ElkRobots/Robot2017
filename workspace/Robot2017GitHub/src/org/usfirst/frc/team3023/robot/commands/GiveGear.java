
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
    	addSequential(new MoveGear((float) .25, 3));
    	addParallel(new AutoTimeDriving((float) -.25,(float) -.25,(float) .5));
    	addSequential(new MoveGear((float) -.25, 3));
    	addParallel(new Print("Reseting Gear Handler..."));
    	addSequential(new HorizontalReset((float) Robot.ds.HorTime.get()));}
    	
    private class Print extends Command{String ln;
    	private Print(String ln) {ln=this.ln;}
    	protected void execute() {System.out.println(ln);}
    	@Override
		protected boolean isFinished() {return true;}}
}