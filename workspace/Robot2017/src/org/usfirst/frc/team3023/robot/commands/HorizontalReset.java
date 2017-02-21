
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
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.dt.Right) {
			Robot.dt.setHorizontalMotor(-.5);
		}
		if (Robot.dt.Left) {
			Robot.dt.setHorizontalMotor(.5);
			;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.dt.setHorizontalMotor(0);
		Robot.ds.HorTime.reset(); Robot.ds.IRCount.reset();
		Robot.dt.Right = false;
		Robot.dt.Left = false;
		Robot.cs.FirstCamCycle = true;
		Robot.dt.GearDone = true; new CheckIR(); Robot.cs.ThreadSleep(0);
		System.out.println("Go Driver!");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() { end();
	}
}
