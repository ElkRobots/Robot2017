
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class AutoTimeDriving extends Command {

	private double left;
	private double right;
	private double wait;

	public AutoTimeDriving(double goLeft, double goRight, double time) {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt);
		left = goLeft;
		right = goRight;
		wait = time;
		setTimeout(wait);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.dt.autoDrive(left, right);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {Robot.dt.autoDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {end();
	}
}
