
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class MoveGearTimed extends Command {

	private int p;
	private float wait;

	// private Timer moveTime = new Timer();
	public MoveGearTimed(int newGo, double Newwait) {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt);
		p = newGo;
		Newwait = wait;
		setTimeout(wait);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.dt.setGearMotor(p);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.dt.setGearMotor(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.dt.setGearMotor(0);
	}
}
