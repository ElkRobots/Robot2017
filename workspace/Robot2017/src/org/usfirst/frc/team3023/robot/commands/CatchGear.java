
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class CatchGear extends Command {

	private Timer move;

	public CatchGear() {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt);
		move = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		move.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (move.get() <= 1) {
			Robot.dt.setGearMotor(1);
		}
		if (move.get() <= 2) {
			Robot.dt.setGearMotor(-1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return move.get() >= 3;
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
