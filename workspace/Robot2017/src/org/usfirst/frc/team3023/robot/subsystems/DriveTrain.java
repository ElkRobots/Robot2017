
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
public class DriveTrain extends Subsystem {
	// Get Port Numbers
	CANTalon FrontLeft = new CANTalon(6);
	CANTalon BackLeft = new CANTalon(2);
	CANTalon FrontRight = new CANTalon(4);
	CANTalon BackRight = new CANTalon(3);
	public CANTalon Horizontal = new CANTalon(1);
	VictorSP GearPlace = new VictorSP(0);
	CANTalon Rope = new CANTalon(5);

	/** Get Speed Values Needed */
	public DriveTrain() {
		// volts per second, test values (need speed this time)
		FrontLeft.setVoltageRampRate(24);
		BackLeft.setVoltageRampRate(24);
		FrontRight.setVoltageRampRate(24);
		BackRight.setVoltageRampRate(24);
	}

	public void control(Joystick getLeftStick, Joystick getRightStick) {
		// adjust for speed | remove while if needed
		FrontLeft.set(getLeftStick.getY() * Robot.oi.getRightZ());
		BackLeft.set(getLeftStick.getY() * Robot.oi.getRightZ());
		FrontRight.set(-(getRightStick.getY() * Robot.oi.getRightZ()));
		BackRight.set(-(getRightStick.getY() * Robot.oi.getRightZ()));
	}

	public void autoDrive(double left, double right) {
		FrontLeft.set(left);
		BackLeft.set(left);
		FrontRight.set(-(right));
		BackRight.set(-(right));
	}

	public void setGearMotor(int go) {
		GearPlace.set(go);
	}

	// public void moveHandler(Joystick leftstick){Horizontal.set(leftstick.getX());}
	public void setHorizontalMotor(double move) {
		GearPlace.set(move);
	}

	// private double Dis;
	public boolean Left;
	public boolean Right;
	public boolean GearDone;

	public void horizontalGear(double dis) {
		// make sure to get correct positive or negative value
		// might need to widen gap for values to account for errors
		//if (!Robot.oi.CamDone) {
			// Dis = Robot.cs.getHorDis();

			if (Robot.cs.FirstCamCycle) {
				Robot.ds.HorTime.start();
				Robot.cs.FirstCamCycle = false;
			}
			while (dis > .5) {
				Horizontal.set(.5);
				Right = true;
			}
			while (dis < -.5) {
				Horizontal.set(-.5);
				Left = true;
			}
			if (-.5 < dis && dis < .5) {
				Horizontal.set(0);
				Robot.ds.HorTime.stop();
				new GiveGear();
				//Robot.cs.ThreadSleep(0);
			}
		//}
		/*
		 * if (manual) { new GiveGearManual(); }
		 */
	}

	public void ropeClimb(double cl) {
		Rope.set(cl);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}/* RANDOM COMMENTO FRIENDO */
