
package org.usfirst.frc.team3023.robot.subsystems;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3023.robot.GripPipeline;
import org.usfirst.frc.team3023.robot.Robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class CamSystem extends Subsystem {
	// Put methods for controlling this subsystem here. Call these from Commands.
	//will the value stay after the command ends?
	//figure out what ratio we really want
	int ImgW = 1280; int ImgH = 720;
	float CenterLeftRec; float CenterRightRec;
	float RealCenter; float HorDis;
	float WantCenter = ImgW/2;
	public VisionThread vt;
	public Object imgSync = new Object();
	public boolean FirstCamCycle = true;
	public boolean ThreadRan;

	UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();

	//fine tune wait (in miliseconds)
	private void ThreadSleep(){try{vt.wait(25);;} catch(InterruptedException e){e.printStackTrace(); 

	System.out.println("Slept wrong?");}}
	
	public void ImagePipe(boolean cam){/* might need to change filter */
		cam0.setResolution(ImgW, ImgH);

		vt = new VisionThread(cam0, new GripPipeline(), pipeline -> {
			//Make sure the amount in array is right
			if(Robot.gp.filterContoursOutput().size() >= 2){
				//need real array numbers for which contours to draw a bounding rectangle around
				//r.x is top left corner
				Rect boundLeft = Imgproc.boundingRect(Robot.gp.filterContoursOutput().get(0));
				Rect boundRight = Imgproc.boundingRect(Robot.gp.filterContoursOutput().get(1));
				synchronized (imgSync){CenterLeftRec = boundLeft.x + (boundLeft.width/2);
				CenterRightRec = boundRight.x + (boundRight.width/2);
				//for finding on cordinate
				RealCenter = ((CenterLeftRec + CenterRightRec)/2);
				HorDis = (Robot.cs.WantCenter - Robot.cs.RealCenter);} //Make sure the values are calculated then wait
				System.out.println("The Distance from Gear to Peg is: " + HorDis); ThreadRan = true; ThreadSleep();}});
		
		if(cam){vt.start(); 
			if(FirstCamCycle){System.out.println("Camera Turning On..."); FirstCamCycle=false;}}}

	public void initDefaultCommand() {/* Set the default command for a subsystem here. 
	setDefaultCommand(new MySpecialCommand()); */}
}
