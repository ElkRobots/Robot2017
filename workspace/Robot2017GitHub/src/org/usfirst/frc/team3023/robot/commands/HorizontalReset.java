
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
        requires(Robot.exampleSubsystem);
        wait = time;}

    // Called just before this Command runs the first time
    protected void initialize() {
    	backTime.reset();
    	backTime.start();}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.dt.Right = true){Robot.dt.autoHorizontal((float) -.25);}
    	if(Robot.dt.Left = true){Robot.dt.autoHorizontal((float) .25);}}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return backTime.get() >= wait;}

    // Called once after isFinished returns true
    protected void end() {Robot.dt.autoHorizontal(0); backTime.stop(); Robot.ds.HorTime.stop();
	  					Robot.dt.Right = false; Robot.dt.Left = false; Robot.ds.IRCount.reset();
	  					Robot.cs.CamOn = false; Robot.cs.FirstCamCycle = false;}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
