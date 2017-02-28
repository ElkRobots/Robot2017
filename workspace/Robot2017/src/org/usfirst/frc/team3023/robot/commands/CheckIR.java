
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class CheckIR extends Command {

	private boolean done;
	public CheckIR() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.exampleSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {done = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.ds.IRBeamBroken()) {
			//Robot.oi.CamDone = false;
			//Robot.cs.ThreadWake();
			System.out.println("IR Beam Broke");
			done = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
