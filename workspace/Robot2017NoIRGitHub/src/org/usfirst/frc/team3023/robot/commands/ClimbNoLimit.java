
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class ClimbNoLimit extends Command {

	int a;
	public ClimbNoLimit(int Newa) {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt); requires(Robot.ds); 
		Newa=a;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.dt.ropeClimb(a);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.dt.placeGear(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.dt.placeGear(0);
	}
}
