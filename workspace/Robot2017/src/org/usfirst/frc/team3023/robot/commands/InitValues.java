
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class InitValues extends Command {

	public InitValues() {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.exampleSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {System.out.println("Initalizing Values...");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.pm.GearDone = true;
		//Robot.oi.CamDone = true;
		System.out.println("Values Reset.");
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
		end();
	}
}
