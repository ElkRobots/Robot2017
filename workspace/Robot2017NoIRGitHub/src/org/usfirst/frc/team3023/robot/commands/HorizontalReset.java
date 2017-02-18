
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class HorizontalReset extends Command {

	private Timer backTime = new Timer(); private float wait;
    public HorizontalReset(float time) {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.dt); requires(Robot.cs); requires(Robot.ds);
        wait = time;}

    // Called just before this Command runs the first time
    protected void initialize() {
    	backTime.reset();
    	backTime.start();}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.dt.Right){Robot.dt.autoHorizontal((float) -.5);}
    	if(Robot.dt.Left){Robot.dt.autoHorizontal((float) .5);}}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return backTime.get() >= wait;}

    // Called once after isFinished returns true
    protected void end() {Robot.dt.autoHorizontal(0); backTime.stop(); Robot.ds.HorTime.stop();
    					  Robot.dt.Right = false; Robot.dt.Left = false; Robot.cs.ThreadRan = false;
    					  Robot.oi.GearDone = true;
    					  System.out.println("Go Driver!");}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
