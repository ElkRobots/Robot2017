
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
	CANTalon FrontLeft = new CANTalon(0);
	CANTalon BackLeft = new CANTalon(2);
	CANTalon FrontRight = new CANTalon(4);
	CANTalon BackRight = new CANTalon(3);
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
		//make expo
		FrontLeft.set(-(getLeftStick.getY() * Robot.oi.getRightZ()));
		BackLeft.set(-(getLeftStick.getY() * Robot.oi.getRightZ()));
		FrontRight.set((getRightStick.getY() * Robot.oi.getRightZ()));
		BackRight.set((getRightStick.getY() * Robot.oi.getRightZ()));
	}

	public void autoDrive(double left, double right) {
		FrontLeft.set(left);
		BackLeft.set(left);
		FrontRight.set(-(right));
		BackRight.set(-(right));
	}
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}/* RANDOM COMMENTO FRIENDO */
