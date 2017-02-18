
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class ManualGear extends Command {

	
	private boolean up; //private Timer stopTime; private float stop;
    public ManualGear(boolean Newup) {
        // Use requires() here to declare subsystem dependencies
       // requires(Robot.dt);
        Newup = up; //Newstop = stop; stopTime=new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {//stopTime.reset(); stopTime.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {if(up){Robot.dt.placeGear((float) .25);}
    if(!up){Robot.dt.placeGear((float) -.25);}
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
