
package org.usfirst.frc.team3023.robot.commands;

import org.usfirst.frc.team3023.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GiveGear extends CommandGroup {
	
	private boolean left; private boolean right;
    public GiveGear(boolean goLeft, boolean goRight) {
    	left = goLeft; right = goRight;
     
    	addParallel(new Print("Placing Gear..."));
    	addSequential(new MoveGearTimed(1, 1.5));
    	addParallel(new AutoTimeDriving(-.25, -.25, .5));
    	addSequential(new MoveGearTimed(-1, 1.5));
    	if(left){
    	/* Turn Left 90 */ addSequential(new AutoTimeDriving(-.5, .5, .5));
		/* Go Left */ addSequential(new AutoTimeDriving(.75, .75, 3));
		/* Turn Right 90 */ addSequential(new AutoTimeDriving(.5, -.5, .5));
		/* Go Forward */ addSequential(new AutoTimeDriving(.75, .75, 3));}
    	if(right){
    	/* Turn Right 90 */ addSequential(new AutoTimeDriving(.5, -.5, .5));
		/* Go Right */ addSequential(new AutoTimeDriving(.75, .75, 3));
		/* Turn Left 90 */ addSequential(new AutoTimeDriving(-.5, .5, .5));
		/* Go Forward */ addSequential(new AutoTimeDriving(.75, .75, 3));}}
    
//    protected void initialize(){Robot.cs.ThreadSleep(0);}
    	
    private class Print extends Command{String ln;
    	private Print(String ln) {ln=this.ln;}
    	protected void execute() {System.out.println(ln);}
    	@Override
		protected boolean isFinished() {return true;}}
}