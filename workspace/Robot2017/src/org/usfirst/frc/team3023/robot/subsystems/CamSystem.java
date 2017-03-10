
package org.usfirst.frc.team3023.robot.subsystems;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3023.robot.GripPipeline;
import org.usfirst.frc.team3023.robot.Robot;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class CamSystem extends Subsystem {
	// Put methods for controlling this subsystem here. Call these from
	// Commands.
	// will the value stay after the command ends?
	// figure out what ratio we really want
	public int ImgW = 640;
	public int ImgH = 480;
	private double CenterLeftRec;
	private double CenterRightRec;
	private double RealCenter;
	private double WantCenter = ImgW / 2;
	private double HorDis;
	public VisionThread vt;
	public Object imgSync = new Object();
	public boolean FirstCamCycle;
	// public boolean ThreadRan;

	public UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();

	public void ThreadStart(){vt.start(); 
	System.out.println("Camera Turning On...");}

	public void ThreadSleep(long ms) {
		try {
			vt.wait(ms); System.out.println("Camera Going to Sleep...");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Slept wrong?");
		}
	}

	public void ThreadWake() {
		vt.notify(); System.out.println("Camera Waking Up...");
	}

	public void initImagePipe() {
		//cam0.setResolution(ImgW, ImgH);

		vt = new VisionThread(cam0, new GripPipeline(), pipeline -> {
			if(Robot.ds.IRBeamBroken()){
			// Makes sure the amount in array is right
			if (Robot.gp.filterContoursOutput().size() >= 2) {
				// need real array numbers for which contours to draw a bounding rectangle around
				// r.x is top left corner
				Rect boundLeft = Imgproc.boundingRect(Robot.gp.filterContoursOutput().get(0));
				Rect boundRight = Imgproc.boundingRect(Robot.gp.filterContoursOutput().get(1));
				synchronized (imgSync) {
					CenterLeftRec = boundLeft.x + (boundLeft.width / 2);
					CenterRightRec = boundRight.x + (boundRight.width / 2);
					// for finding on cordinate
					RealCenter = ((CenterLeftRec + CenterRightRec) / 2);
					HorDis = (Robot.cs.WantCenter - Robot.cs.RealCenter);
				}
				System.out.println("The Distance from Gear to Peg is: " + HorDis);
				Robot.dt.horizontalGear(HorDis);}
				/*ThreadSleep(15);*/}}); ThreadStart();}
	public void InitCam(){cam0.setResolution(800, 600); cam0.setFPS(30); System.out.println("Camera Turning On...");}

	public void initDefaultCommand() {
		/*
		 * Set the default command for a subsystem here. setDefaultCommand(new
		 * MySpecialCommand());
		 */}
}
