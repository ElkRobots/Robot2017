
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class AutoMiddlePegPlusTurn extends Command {
	
	private boolean left; private boolean right;
    public AutoMiddlePegPlusTurn(boolean turnLeft, boolean turnRight) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
        left = turnLeft; right = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	new AutoIRDrivingPlusTurn(.75, .75, left, right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
