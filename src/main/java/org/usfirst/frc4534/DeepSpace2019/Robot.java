// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4534.DeepSpace2019;

import com.kauailabs.navx.frc.*;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SampleRobot;
import org.usfirst.frc4534.DeepSpace2019.commands.*;
import org.usfirst.frc4534.DeepSpace2019.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static EndgameExtensions endgameExtensions;
    public static Limelight limelight;
    public static Lift lift;
    public static Navx navx;
    public static AHRS ahrs;
    public static PistonMove pistonMove;
    // Joystick joystick1;
    // JoystickButton button;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        intake = new Intake();
        endgameExtensions = new EndgameExtensions();
        limelight = new Limelight();
        lift = new Lift();
        navx = new Navx();
        pistonMove = new PistonMove();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());
        // joystick1 = new Joystick(0);
        
        // button = new JoystickButton(joystick1, 1);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);

        try {
		// 	/***********************************************************************
		// 	 * navX-MXP:
		// 	 * - Communication via RoboRIO MXP (SPI, I2C, TTL UART) and USB.            
		// 	 * - See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface.
		// 	 * 
		// 	 * navX-Micro:
		// 	 * - Communication via I2C (RoboRIO MXP or Onboard) and USB.
		// 	 * - See http://navx-micro.kauailabs.com/guidance/selecting-an-interface.
		// 	 * 
		// 	 * Multiple navX-model devices on a single robot are supported.
		// 	 ************************************************************************/
        //     //ahrs = new AHRS(SerialPort.Port.kUSB1);
             ahrs = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData, (byte)50);                                                                                                                                                                                                          
             ahrs.enableLogging(true);
         } catch (RuntimeException ex ) {
             DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
         }
         Timer.delay(1.0);
    	// //UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
    	// //cam.setResolution(640, 480);  
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        while (isEnabled() && isOperatorControl()) {
            
            Timer.delay(0.020);		/* wait for one motor update time period (50Hz)     */
            
            // boolean zero_yaw_pressed = false; //stick.getTrigger();
            // if ( zero_yaw_pressed ) {
            //    ahrs.zeroYaw();
            //}

            /* Display 6-axis Processed Angle Data                                      */
            SmartDashboard.putBoolean(  "IMU_Connected",        ahrs.isConnected());
            SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
            SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
            SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
            SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
            
            /* Display tilt-corrected, Magnetometer-based heading (requires             */
            /* magnetometer calibration to be useful)                                   */
            
            SmartDashboard.putNumber(   "IMU_CompassHeading",   ahrs.getCompassHeading());
            
            /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
            SmartDashboard.putNumber(   "IMU_FusedHeading",     ahrs.getFusedHeading());

            /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
            /* path for upgrading from the Kit-of-Parts gyro to the navx MXP            */
            
            SmartDashboard.putNumber(   "IMU_TotalYaw",         ahrs.getAngle());
            SmartDashboard.putNumber(   "IMU_YawRateDPS",       ahrs.getRate());

            /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
            
            SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
            SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
            SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
            SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());

            /* Display estimates of velocity/displacement.  Note that these values are  */
            /* not expected to be accurate enough for estimating robot position on a    */
            /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
            /* of these errors due to single (velocity) integration and especially      */
            /* double (displacement) integration.                                       */
            
            SmartDashboard.putNumber(   "Velocity_X",           ahrs.getVelocityX());
            SmartDashboard.putNumber(   "Velocity_Y",           ahrs.getVelocityY());
            SmartDashboard.putNumber(   "Displacement_X",       ahrs.getDisplacementX());
            SmartDashboard.putNumber(   "Displacement_Y",       ahrs.getDisplacementY());
            
            /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
            /* NOTE:  These values are not normally necessary, but are made available   */
            /* for advanced users.  Before using this data, please consider whether     */
            /* the processed data (see above) will suit your needs.                     */
            
            SmartDashboard.putNumber(   "RawGyro_X",            ahrs.getRawGyroX());
            SmartDashboard.putNumber(   "RawGyro_Y",            ahrs.getRawGyroY());
            SmartDashboard.putNumber(   "RawGyro_Z",            ahrs.getRawGyroZ());
            SmartDashboard.putNumber(   "RawAccel_X",           ahrs.getRawAccelX());
            SmartDashboard.putNumber(   "RawAccel_Y",           ahrs.getRawAccelY());
            SmartDashboard.putNumber(   "RawAccel_Z",           ahrs.getRawAccelZ());
            SmartDashboard.putNumber(   "RawMag_X",             ahrs.getRawMagX());
            SmartDashboard.putNumber(   "RawMag_Y",             ahrs.getRawMagY());
            SmartDashboard.putNumber(   "RawMag_Z",             ahrs.getRawMagZ());
            SmartDashboard.putNumber(   "IMU_Temp_C",           ahrs.getTempC());
            SmartDashboard.putNumber(   "IMU_Timestamp",        ahrs.getLastSensorTimestamp());
            
            /* Omnimount Yaw Axis Information                                           */
            /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
            AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
            SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
            SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
            
            /* Sensor Board Information                                                 */
            SmartDashboard.putString(   "FirmwareVersion",      ahrs.getFirmwareVersion());
            
            /* Quaternion Data                                                          */
            /* Quaternions are fascinating, and are the most compact representation of  */
            /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
            /* from the Quaternions.  If interested in motion processing, knowledge of  */
            /* Quaternions is highly recommended.                                       */
            SmartDashboard.putNumber(   "QuaternionW",          ahrs.getQuaternionW());
            SmartDashboard.putNumber(   "QuaternionX",          ahrs.getQuaternionX());
            SmartDashboard.putNumber(   "QuaternionY",          ahrs.getQuaternionY());
            SmartDashboard.putNumber(   "QuaternionZ",          ahrs.getQuaternionZ());
            
            /* Connectivity Debugging Support                                           */
            SmartDashboard.putNumber(   "IMU_Byte_Count",       ahrs.getByteCount());
            SmartDashboard.putNumber(   "IMU_Update_Count",     ahrs.getUpdateCount());
        }
    }
}
