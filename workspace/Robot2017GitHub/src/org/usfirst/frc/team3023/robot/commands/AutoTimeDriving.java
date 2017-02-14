
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class AutoTimeDriving extends Command {

	private float left; private float right; private float wait;
	private Timer theTime = new Timer();
	
    public AutoTimeDriving(float goLeft, float goRight, float time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
        left = goLeft; right = goRight; wait = time;}

    // Called just before this Command runs the first time
    protected void initialize() {
    	theTime.reset();
    	theTime.start();}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.autoDrive(left, right);}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return theTime.get() >= wait;}

    // Called once after isFinished returns true
    protected void end() {theTime.stop();}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
