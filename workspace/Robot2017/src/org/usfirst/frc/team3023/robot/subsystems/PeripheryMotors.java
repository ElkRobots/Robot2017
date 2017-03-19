
package org.usfirst.frc.team3023.robot.subsystems;

import org.usfirst.frc.team3023.robot.Robot;
import org.usfirst.frc.team3023.robot.commands.GiveGear;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PeripheryMotors extends Subsystem {

	CANTalon Rope = new CANTalon(5);
	CANTalon Horizontal = new CANTalon(1);
	VictorSP GearPlace = new VictorSP(9);
	
	public void setGearMotor(double go) {
		GearPlace.set(go);
	}

	public void setHorizontalMotor(double move) {
		Horizontal.set(move);
	}

	public void manualArm(Joystick RS) {
		Horizontal.set(RS.getX());
		GearPlace.set(RS.getY());
	}

	public void ropeClimb(double cl) {
		Rope.set(cl);
	}
	
	// private double Dis;
	public boolean GearDone;
	public void horizontalGear(double dis) {
		// make sure to get correct positive or negative value
		// might need to widen gap for values to account for errors
		// if (!Robot.oi.CamDone) {
		// Dis = Robot.cs.getHorDis();

		if (dis > .5) {
			Horizontal.set(.5);
		}
		if (dis < -.5) {
			Horizontal.set(-.5);
		}
		if (-.5 < dis && dis < .5) {
			Horizontal.set(0);
			new GiveGear(false, false);
		}
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

