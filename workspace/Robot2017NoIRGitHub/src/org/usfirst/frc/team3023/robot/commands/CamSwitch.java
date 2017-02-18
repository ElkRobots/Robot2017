
package org.usfirst.frc.team3023.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.Robot;

/**
 *
 */
public class CamSwitch extends Command {

	private boolean a; private boolean b; private boolean cam;
    public CamSwitch(boolean Newa, boolean Newb, boolean Newcam) {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.dt); requires(Robot.cs);
        a=Newa; b=Newb; cam=Newcam;}

    // Called just before this Command runs the first time
    protected void initialize() {Robot.oi.GearDone=false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {Robot.dt.horizontalGear(a, b);Robot.cs.ImagePipe(cam);}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.GearDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
