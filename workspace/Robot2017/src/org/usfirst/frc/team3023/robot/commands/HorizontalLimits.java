
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class HorizontalLimits extends Command {

    public HorizontalLimits() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.ds.isLeftSwitchHit()){
    		Robot.pm.setHorizontalMotor(0);
    		System.out.println("Left Llimit!");
    	}
    	if(Robot.ds.isRightSwitchHit()){
    		Robot.pm.setHorizontalMotor(0);
    		System.out.println("Right Limit!");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
