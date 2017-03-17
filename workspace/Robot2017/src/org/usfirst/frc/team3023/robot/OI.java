package org.usfirst.frc.team3023.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3023.robot.commands.CatchGear;
import org.usfirst.frc.team3023.robot.commands.ClimbNoLimit;
import org.usfirst.frc.team3023.robot.commands.IRSwitch;
import org.usfirst.frc.team3023.robot.commands.ManualGear;
import org.usfirst.frc.team3023.robot.commands.ManualHorizontal;
import org.usfirst.frc.team3023.robot.commands.ManualReset;
import org.usfirst.frc.team3023.robot.commands.MoveGear;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick leftstick = new Joystick(0);
	public Joystick rightstick = new Joystick(1);
	Button Right3 = new JoystickButton(rightstick, 3);
	Button Right2 = new JoystickButton(rightstick, 2);
	Button Right10 = new JoystickButton(rightstick, 10);
	Button RightTrigger = new JoystickButton(rightstick, 1);
	Button LeftTrigger = new JoystickButton(leftstick, 1);
	//public boolean CamDone;
	//public boolean CamOn; // public boolean Manual = false;

	public OI() {
		Right3.whenPressed(new ClimbNoLimit(1));
		Right3.whenReleased(new ClimbNoLimit(0));
		Right2.whenPressed(new IRSwitch());
		
		// positive is forward

		RightTrigger.whenPressed(new CatchGear());
		Right10.whenPressed(new MoveGear(1));
		Right10.whenReleased(new MoveGear(0));

		//Left3.whenPressed(new ManualReset());
	}

	public Joystick getLeftStick() {
		return leftstick;
	}

	public Joystick getRightStick() {
		return rightstick;
	}
	
	public double getRightZ(){return (-rightstick.getZ() + 1)/2;}
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

// Start the command when the button is released and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenReleased(new ExampleCommand());