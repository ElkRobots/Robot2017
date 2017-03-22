
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class AutoIRDrivingPlusTurn extends Command {

	private double Driveleft;
	private double Driveright;
	private boolean left;
	private boolean right;

	public AutoIRDrivingPlusTurn(double goLeft, double goRight, boolean turnLeft, boolean turnRight) {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt);
		Driveleft = goLeft;
		Driveright = goRight;
		left = turnLeft;
		right = turnRight;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.dt.autoDrive(Driveleft, Driveright);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.ds.IRBeamBroken();
	}

	// Called once after isFinished returns true
	protected void end() {Robot.dt.autoDrive(0, 0); new GiveGear(left, right).start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {Robot.dt.autoDrive(0, 0);
	}
}
