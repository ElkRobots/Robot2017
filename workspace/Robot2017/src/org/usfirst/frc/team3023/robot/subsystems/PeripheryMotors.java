
package org.usfirst.frc.team3023.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PeripheryMotors extends Subsystem {

	CANTalon Rope = new CANTalon(5);

	public void ropeClimb(double cl) {
		Rope.set(cl);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

