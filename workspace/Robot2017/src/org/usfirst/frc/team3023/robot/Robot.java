
package org.usfirst.frc.team3023.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3023.robot.commands.CheckIR;
import org.usfirst.frc.team3023.robot.commands.ClimbNoLimit;
import org.usfirst.frc.team3023.robot.commands.ExampleCommand;
import org.usfirst.frc.team3023.robot.commands.InitValues;
import org.usfirst.frc.team3023.robot.commands.JoystickDrive;
import org.usfirst.frc.team3023.robot.subsystems.CamSystem;
import org.usfirst.frc.team3023.robot.subsystems.DigitalSensors;
import org.usfirst.frc.team3023.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3023.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3023.robot.subsystems.PeripheryMotors;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain dt;
	public static PeripheryMotors pm;
	public static GripPipeline gp;
	public static CamSystem cs;
	public static DigitalSensors ds;
	private Command teleopCommand;
	private Command startGear;

	Command autonomousCommand;
	SendableChooser Autochooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		cs = new CamSystem();
		dt = new DriveTrain();
		pm = new PeripheryMotors();
		ds = new DigitalSensors();
		gp = new GripPipeline();

		new InitValues();
		Robot.cs.InitCam();
		// this is the original auto
		// autonomousCommand=new AutoRun(0, false, 0);

		//change to commands
		Autochooser = new SendableChooser();
		Autochooser.addDefault("NoIR Auto", new AutoRun(0, false, false, false));
		Autochooser.addObject("Left Peg Auto", new AutoRun(1, true, false, false));
		Autochooser.addObject("Middle Peg, No Turn Auto", new AutoRun(2, false, false, false));
		Autochooser.addObject("Middle Peg, Turn Left Auto", new AutoRun(2, true, true, false));
		Autochooser.addObject("Middle Peg, Turn Right Auto", new AutoRun(2, true, false, true));
		Autochooser.addObject("Right Peg Auto", new AutoRun(3, true, false, false));
		SmartDashboard.putData("Auto mode", Autochooser);

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		new InitValues();
		//Robot.pm.ropeClimb(0);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) Autochooser.getSelected();
		System.out.println(Autochooser.getSelected());


		/**
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "Left Peg": autonomousCommand
		 * = new AutoRun(1, 1, 0); break; case "Middle Peg then Stop": default:
		 * autonomousCommand = new AutoRun(2, 0, 0); break; case "Middle Peg
		 * then Cross Left": autonomousCommand = new AutoRun(2, 1, 1); break;
		 * case "Middle Peg then Cross Right": autonomousCommand = new
		 * AutoRun(2, 1, 0); break; case "Right Peg": autonomousCommand = new
		 * AutoRun(3, 1, 0); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		teleopCommand = new JoystickDrive();
		teleopCommand.start();
		new InitValues();
		new CheckIR();
		//Robot.pm.ropeClimb(1);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
