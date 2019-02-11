// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// It works! Kinda. DON'T MESS WITH IT

package org.usfirst.frc4534.DeepSpace2019.subsystems;

import com.kauailabs.navx.frc.*;

import org.usfirst.frc4534.DeepSpace2019.Robot;
import org.usfirst.frc4534.DeepSpace2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.InvertType;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX leftMasterJPL;
    private WPI_TalonSRX rightMasterJPL;
    private DifferentialDrive deltaD;
    private Encoder leftEncoder;
    private Compressor compressor;
    private AnalogGyro gyro;
    private Encoder rightEncoder;
    private WPI_TalonSRX leftFollowerJPLT;
    private WPI_TalonSRX rightFollowerJPLT;
    private WPI_VictorSPX leftFollowerJPLV;
    private WPI_VictorSPX rightFollowerJPLV;
    private Solenoid shifter; 
    private ControlMode follower = com.ctre.phoenix.motorcontrol.ControlMode.Follower;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftMasterJPL = new WPI_TalonSRX(0);
        
        
        
        rightMasterJPL = new WPI_TalonSRX(1);
        
        
        
        deltaD = new DifferentialDrive(leftMasterJPL, rightMasterJPL);
        addChild("deltaD",deltaD);
        deltaD.setSafetyEnabled(true);
        deltaD.setExpiration(0.1);
        deltaD.setMaxOutput(1.0);

        
        leftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        addChild("leftEncoder",leftEncoder);
        leftEncoder.setDistancePerPulse(1.0);
        leftEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        compressor = new Compressor(30);
        addChild("compressor",compressor);
        
        
        gyro = new AnalogGyro(0);
        addChild("gyro",gyro);
        gyro.setSensitivity(0.007);
        
        rightEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        addChild("rightEncoder",rightEncoder);
        rightEncoder.setDistancePerPulse(1.0);
        rightEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        leftFollowerJPLT = new WPI_TalonSRX(2);
        
        
        rightFollowerJPLT = new WPI_TalonSRX(3);
        
        
        
        leftFollowerJPLV = new WPI_VictorSPX(4);
        
        
        
        rightFollowerJPLV = new WPI_VictorSPX(5);

        // shifter = new Solenoid(0, 1);
        // addChild("shifter", shifter);
        
        
        leftFollowerJPLT.follow(leftMasterJPL);
        leftFollowerJPLV.follow(leftMasterJPL);
        rightFollowerJPLT.follow(rightMasterJPL);
        rightFollowerJPLV.follow(rightMasterJPL);

        leftMasterJPL.setInverted(false);
        rightMasterJPL.setInverted(false);
        leftFollowerJPLT.setInverted(InvertType.OpposeMaster);
        rightFollowerJPLT.setInverted(InvertType.OpposeMaster);
        leftFollowerJPLV.setInverted(InvertType.FollowMaster);
        rightFollowerJPLV.setInverted(InvertType.FollowMaster);
        // deltaD.setRightSideInverted(false);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftMasterJPL.configOpenloopRamp(0.5, 0);
        rightMasterJPL.configOpenloopRamp(0.5, 0);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void ArcadeDrive(double speed, double rotation) {
        deltaD.arcadeDrive(speed, rotation, true);
    }

    public void TankDrive(double leftSpeed, double rightSpeed) {
        deltaD.tankDrive(leftSpeed, rightSpeed);
    }

    public void resetDistanceCounter() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void StartCompressor() {
        compressor.start();
    }

    public void StopCompressor() {
        compressor.stop();
    }

    public double getLeftRate() {
        return leftEncoder.getRate();
    }

    public double getRightRate() {
        return rightEncoder.getRate();
    }

    public void resetGyroAngle() {
        Robot.ahrs.reset();
    }

    public double getGyroAngle() {
        return Robot.ahrs.getYaw();
    }

    public double getLeftDistanceCounter() {
        return leftEncoder.getDistance();
    }

    public double getRightDistanceCounter() {
        return rightEncoder.getDistance();
    }

    public boolean getShifter() {
        return shifter.get();
    }
    public void setShifter(boolean state) {
        shifter.set(state);
    }

    public void resetMotorControllers(){
        leftMasterJPL.configFactoryDefault();
        rightMasterJPL.configFactoryDefault();
        leftFollowerJPLT.configFactoryDefault();
        rightFollowerJPLT.configFactoryDefault();
        leftFollowerJPLV.configFactoryDefault();
        rightFollowerJPLV.configFactoryDefault();
    }

    /* public void setToFollow() {
        leftFollowerJPLT.follow(leftMasterJPL);
        leftFollowerJPLV.follow(leftMasterJPL);
        rightFollowerJPLT.follow(rightMasterJPL);
        rightFollowerJPLV.follow(rightMasterJPL);
    } */

    /* public void setInversions() {
        leftMasterJPL.setInverted(false);
        rightMasterJPL.setInverted(true);
        leftFollowerJPLT.setInverted(true);
        rightFollowerJPLT.setInverted(false);
        leftFollowerJPLV.setInverted(false);
        rightFollowerJPLV.setInverted(true);
        deltaD.setRightSideInverted(false);
    } */
}