package org.usfirst.frc.team3023.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3023.robot.commands.CamSwitch;
import org.usfirst.frc.team3023.robot.commands.CatchGear;
import org.usfirst.frc.team3023.robot.commands.Climb;
import org.usfirst.frc.team3023.robot.commands.ClimbNoLimit;
import org.usfirst.frc.team3023.robot.commands.GiveGear;
import org.usfirst.frc.team3023.robot.commands.ManualGear;
import org.usfirst.frc.team3023.robot.commands.MoveGear;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
   public Joystick leftstick=new Joystick(1);;
   public Joystick rightstick=new Joystick (0);
   Button Right3 = new JoystickButton(rightstick, 3);
   Button RightButton = new JoystickButton(rightstick, 2);
   Button BottomRight = new JoystickButton(rightstick, 10);
   Button RightTrigger = new JoystickButton(rightstick, 1);
   Button BottomLeft = new JoystickButton(leftstick, 10);
   Button LeftUp = new JoystickButton(leftstick, 3);
   Button LeftDown = new JoystickButton(leftstick, 2);
   public boolean GearDone=false;
   //public boolean Cam = false; public boolean Manual = false;
   
   public OI(){
	   
	   Right3.whenActive(new ClimbNoLimit(1));
	   //positive is fowrad
	   BottomLeft.whenActive(new MoveGear((float) .2));
	   
	   RightButton.whenActive(new CamSwitch(true, false, true));
	   	   
   	   RightTrigger.whenPressed(new CatchGear());
   	   
   	   LeftUp.whenPressed(new ManualGear(true));
   	   LeftDown.whenPressed(new ManualGear(false));
   	   //LeftUp.whenReleased(new ManualGear(false, true));
   	   //LeftDown.whenReleased(new ManualGear(true, true));
   }

public Joystick getLeftStick()
   {return leftstick;}
public Joystick getRightStick()
   {return rightstick;}
}

//// CREATING BUTTONS
// One type of button is a joystick button which is any button on a joystick.
// You create one by telling it which joystick it's on and which button
// number it is.
// Joystick stick = new Joystick(port);
// Button button = new JoystickButton(stick, buttonNumber);

// There are a few additional built in buttons you can use. Additionally,
// by subclassing Button you can create custom triggers and bind those to
// commands the same as any other Button.

//// TRIGGERING COMMANDS WITH BUTTONS
// Once you have a button, it's trivial to bind it to a button in one of
// three ways:

// Start the command when the button is pressed and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenPressed(new ExampleCommand());

// Run the command while the button is being held down and interrupt it once
// the button is released.
// button.whileHeld(new ExampleCommand());

// Start the command when the button is released  and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenReleased(new ExampleCommand());