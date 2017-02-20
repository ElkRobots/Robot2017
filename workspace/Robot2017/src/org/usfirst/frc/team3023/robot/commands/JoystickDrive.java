package org.usfirst.frc.team3023.robot.commands;

import org.usfirst.frc.team3023.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command {

	public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(!Robot.oi.CamOn){Robot.dt.control(Robot.oi.leftstick, Robot.oi.rightstick);} /*Robot.dt.moveHandler(Robot.oi.leftstick);*/
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
