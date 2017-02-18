
package org.usfirst.frc.team3023.robot.subsystems;

import org.usfirst.frc.team3023.robot.Robot;
import org.usfirst.frc.team3023.robot.commands.GiveGear;
import org.usfirst.frc.team3023.robot.commands.GiveGearManual;
import org.usfirst.frc.team3023.robot.commands.MoveGear;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	//Get Port Numbers
	CANTalon FrontLeft = new CANTalon(6);
	CANTalon BackLeft = new CANTalon(2);
	CANTalon FrontRight = new CANTalon(4);
	CANTalon BackRight = new CANTalon(3);
	public CANTalon Horizontal = new CANTalon(1);
	VictorSP GearPlace = new VictorSP(0);
	CANTalon Rope = new CANTalon(5);
		
	/**  Get Speed Values Needed */
	public DriveTrain(){
		//volts per second, test values (need speed this time)
		FrontLeft.setVoltageRampRate(24);
		BackLeft.setVoltageRampRate(24);
		FrontRight.setVoltageRampRate(24);
		BackRight.setVoltageRampRate(24);}
    
    public void control(Joystick getLeftStick, Joystick getRightStick){
    	//adjust for speed | remove while if needed
    	/*while(!Robot.oi.GearDone){
    		FrontLeft.set(0);
    		BackLeft.set(0);
    		FrontRight.set(0);
    		BackRight.set(0);}*/
    	FrontLeft.set(getLeftStick.getY() * getLeftStick.getZ());
		BackLeft.set(getLeftStick.getY() * getLeftStick.getZ());
		FrontRight.set(-(getRightStick.getY() * getLeftStick.getZ()));
		BackRight.set(-(getRightStick.getY() * getLeftStick.getZ()));}
    
    public void autoDrive(double left, double right){
    	FrontLeft.set(left);
    	BackLeft.set(left);
    	FrontRight.set(-(right));
    	BackRight.set(-(right));}
    
    public void placeGear(float go){GearPlace.set(go);}
    //public void moveHandler(Joystick leftstick){Horizontal.set(leftstick.getX());}
    public void autoHorizontal(float move){GearPlace.set(move);}
        
	private float Dis = Robot.cs.HorDis; public boolean Left; public boolean Right;
	
    public void horizontalGear(boolean cam, boolean manual){
    	//make sure to get correct positive or negative value
    	//might need to sync
    	if(cam && Robot.cs.ThreadRan){
    	/*might need to widen gap for values to account for errors */
    		Robot.ds.HorTime.reset(); Robot.ds.HorTime.start(); System.out.println("Driver, Stop!");
    		if(Dis > .5){Horizontal.set(.5); Right = true;}
    		else if(Dis < -.5){Horizontal.set(-.5); Left = true;}
    		else if(-.5 < Dis && Dis < .5){Horizontal.set(0); Robot.ds.HorTime.stop(); new GiveGear();}}
    	if(manual){new GiveGearManual();}}
    
    public void ropeClimb(double cl){Rope.set(cl);}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	}}/*RANDOM COMMENTO FRIENDO*/