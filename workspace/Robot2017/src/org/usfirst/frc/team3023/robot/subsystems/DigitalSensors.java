
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
		DigitalInput LimSw = new DigitalInput(0);
		Counter LimCount = new Counter(LimSw);
		
		DigitalInput IRBeam = new DigitalInput(1);
		public Counter IRCount = new Counter(IRBeam);
		public Timer HorTime = new Timer();
		
	//Counters sees at least 1 pulse because the constant steam stopped
	//This is because the pull-up resistor is read for the value and when the switch is hit, 
	//it connects to the ground and the charge goes to the path of least resistance so the read value goes down
	public boolean isSwitchHit() {
		return LimCount.get() > 0;
	}

	public boolean IRBeamBroken() {
		return IRCount.get() > 0;
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }}