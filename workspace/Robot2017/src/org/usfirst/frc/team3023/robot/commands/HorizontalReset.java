
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class HorizontalReset extends Command {

	private double wait;

	public HorizontalReset(double time) {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt); requires(Robot.cs); requires(Robot.ds);
		wait = time;
		setTimeout(wait);
	}

	// Called just before this Command runs the first time
	protected void initialize() {Robot.ds.IRCount.reset();
	System.out.println("Go Driver!");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
//		if (Robot.pm.Right) {
//			Robot.pm.setHorizontalMotor(-.5);
//		}
//		if (Robot.pm.Left) {
//			Robot.pm.setHorizontalMotor(.5);
//			;
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.pm.setHorizontalMotor(0);
		Robot.pm.GearDone = true; Robot.cs.ThreadWake();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() { end();
	}
}
