
package org.usfirst.frc.team3023.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DigitalSensors extends Subsystem {
	//Get Real Input Wiring
	DigitalInput LimSwL = new DigitalInput(0);
	Counter LimCountL = new Counter(LimSwL);

	DigitalInput LimSwR = new DigitalInput(1);
	Counter LimCountR = new Counter(LimSwR);
	
	DigitalInput IRBeam = new DigitalInput(1);
	public Counter IRCount = new Counter(IRBeam);	
	public int sw = 0;

	//Counters sees at least 1 pulse because the constant steam stopped
	//This is because the pull-up resistor is read for the value and when the switch is hit, 
	//it connects to the ground and the charge goes to the path of least resistance so the read value goes down
	public boolean isLeftSwitchHit() {
		return LimCountL.get() > 0;
	}
	
	public boolean isRightSwitchHit() {
		return LimCountR.get() > 0;
	}

	public boolean IRBeamBroken() {
		return (IRCount.get()/* + sw*/) > 0;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}}