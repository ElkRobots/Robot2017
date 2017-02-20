
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class ManualGear extends Command {

	
	private int go; //private Timer stopTime; private float stop;
    public ManualGear(int Newgo) {
        // Use requires() here to declare subsystem dependencies
       // requires(Robot.dt);
        Newgo = go; //Newstop = stop; stopTime=new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {//stopTime.reset(); stopTime.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {Robot.dt.setGearMotor(go);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {Robot.dt.setGearMotor(0);}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {Robot.dt.setGearMotor(0);
    }
}
