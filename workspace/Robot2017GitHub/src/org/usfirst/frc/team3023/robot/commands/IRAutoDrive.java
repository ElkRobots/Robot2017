
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class IRAutoDrive extends Command {

	private float left; private float right;
	
    public IRAutoDrive(float newLeftDis, float newRightDis) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
        left = newLeftDis; right = newRightDis;}

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.autoDrive(left, right);}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.ds.IRBreak;}

    // Called once after isFinished returns true
    protected void end() {Robot.dt.autoDrive(0, 0);}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
