/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4534.DeepSpace2019.subsystems;

import org.usfirst.frc4534.DeepSpace2019.Robot;
import org.usfirst.frc4534.DeepSpace2019.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
    private WPI_VictorSPX intakeMotor;
    private DigitalInput ballDetect;
    private DigitalInput ballDetect2;

    public Intake() {
        intakeMotor = new WPI_VictorSPX(7);
        
        ballDetect = new DigitalInput(6);

        ballDetect2 = new DigitalInput(7);
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("yeah ok boomer", Robot.intake.detectBall());
        SmartDashboard.putBoolean("yeah ok buddy", Robot.intake.detectBall2());
    }

    public void intakeSet(double rate) {
        intakeMotor.set(rate);
    }

    public void intakeOn() {
        intakeMotor.set(0.9);
    }

    public boolean detectBall() {
        return ballDetect.get();
    }
    
    public boolean detectBall2() {
        return ballDetect2.get();
    }

    // public void isBallGot() {
    //     SmartDashboard.putBoolean("Ball?", detectBall());
    // }
}

