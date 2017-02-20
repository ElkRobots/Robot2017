
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class CamSwitch extends Command {

	public CamSwitch() {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt); requires(Robot.cs);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.oi.CamDone = false; Robot.dt.GearDone = false;

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.cs.ImagePipe();
		Robot.dt.horizontalGear();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.dt.GearDone;
	}

	// Called once after isFinished returns true
	protected void end() {
		// Robot.oi.CamOn = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
