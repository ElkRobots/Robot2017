
package org.usfirst.frc.team3023.robot.commands;

import org.usfirst.frc.team3023.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GiveGearManual extends CommandGroup {

    public GiveGearManual() {
     
    	addParallel(new Print("Placing Gear..."));
    	addSequential(new MoveGearTimed((float) .25, (float) 1.5));
    	addParallel(new AutoTimeDriving((float) -.25,(float) -.25,(float) .5));
    	addSequential(new MoveGearTimed((float) -.25, (float) 1.5));
    	//addParallel(new Print("Reseting Gear Handler..."));
    	//addSequential(new HorizontalReset((float) Robot.ds.HorTime.get()));
    	}
    	
    public class Print extends Command{String ln;
    	private Print(String ln) {ln=this.ln;}
    	protected void execute() {System.out.println(ln);}
    	@Override
		protected boolean isFinished() {return true;}}
}