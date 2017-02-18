
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class MoveGear extends Command {

	private float p; private float wait;
	//private Timer moveTime = new Timer();
	public MoveGear(float newGo) {
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.dt);
		p = newGo; //wait = newWait;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//moveTime.start();
		//setTimer(25);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.dt.placeGear(p);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {Robot.dt.placeGear(0);}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {Robot.dt.placeGear(0);
	}
}
