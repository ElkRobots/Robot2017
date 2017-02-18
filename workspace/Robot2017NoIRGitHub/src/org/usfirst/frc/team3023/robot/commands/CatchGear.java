
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class CatchGear extends Command {
	
	private Timer move; private Timer wait;
    public CatchGear() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.dt);
        wait = new Timer(); move = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {wait.reset(); wait.start(); move.reset(); move.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {if(move.get() <= .25){Robot.dt.placeGear((float) 2);}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return wait.get() >= 5;
    }

    // Called once after isFinished returns true
    protected void end() {move.reset(); move.start(); if(move.get() >= .25){Robot.dt.placeGear((float) -.25);}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
