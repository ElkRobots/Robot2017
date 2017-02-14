
package org.usfirst.frc.team3023.robot.subsystems;

import org.usfirst.frc.team3023.robot.Robot;
import org.usfirst.frc.team3023.robot.commands.GiveGear;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	//Get Port Numbers
	CANTalon FrontLeft = new CANTalon(1);
	CANTalon BackLeft = new CANTalon(2);
	CANTalon FrontRight = new CANTalon(3);
	CANTalon BackRight = new CANTalon(4);
	CANTalon Horizontal = new CANTalon(5);
	CANTalon GearPlace = new CANTalon(6);
	CANTalon Rope = new CANTalon(7);
	
	public boolean Left; public boolean Right;
	/** Get Speed Values Needed */
	public DriveTrain(){
		//volts per second, test values (need speed this time)
		FrontLeft.setVoltageRampRate(24);
		BackLeft.setVoltageRampRate(24);
		FrontRight.setVoltageRampRate(24);
		BackRight.setVoltageRampRate(24);}
    
    public void control(Joystick getLeftStick, Joystick getRightStick){
    	//adjust for speed
    	while(Robot.ds.IRBreak = false){
    		FrontLeft.set(getLeftStick.getY());
    		BackLeft.set(getLeftStick.getY());
    		FrontRight.set(getRightStick.getY());
    		BackRight.set(getRightStick.getY());}}
    
    public void autoDrive(double left, double right){
    	FrontLeft.set(left);
    	BackLeft.set(left);
    	FrontRight.set(right);
    	BackRight.set(right);}
    
    public void placeGear(float go){GearPlace.set(go);}
    public void autoHorizontal(float move){Horizontal.set(move);}
        
    public void horizontalGear(){
    	//make sure to get correct positive or negative value
    	//might need to sync with vt
    	
    	if(Robot.ds.IRBreak = true){
    	/*might need if | might need to widen gap for values to account for errors */
    		Robot.ds.HorTime.reset(); Robot.ds.HorTime.start(); Robot.cs.CamOn = true;
    		while(Robot.cs.HorDis > .5){Horizontal.set(.25); Right = true;}
    		while(Robot.cs.HorDis < -.5){Horizontal.set(-.25); Left = true;}
    		if(-.5 < Robot.cs.HorDis && Robot.cs.HorDis < .5){Horizontal.set(0); Robot.ds.HorTime.stop(); new GiveGear();}}}
    
    public void ropeClimb(double cl){Rope.set(cl);}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	}}/*RANDOM COMMENTO FRIENDO*/