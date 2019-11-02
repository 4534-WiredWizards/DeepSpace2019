
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4534.DeepSpace2019.subsystems;
import org.usfirst.frc4534.DeepSpace2019.Robot;
import org.usfirst.frc4534.DeepSpace2019.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * Add your docs here.
 */
public class RedesignedLift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private WPI_VictorSPX liftMotor;
    private DigitalInput liftLowerLimit;
    private DigitalInput liftUpperLimit;
    private Encoder liftEncoder;

    public RedesignedLift() {
        liftMotor = new WPI_VictorSPX(6);

        liftUpperLimit = new DigitalInput(8);

        liftEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        addChild("liftEncoder",liftEncoder);
        liftEncoder.setDistancePerPulse(1.0);
        liftEncoder.setPIDSourceType(PIDSourceType.kRate);

        liftMotor.configOpenloopRamp(1, 0);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LiftWithJoystick());
    }

    public void liftSet(double rate) {
        liftMotor.set(rate);
    }

    public void resetLiftEncoder() {
        liftEncoder.reset();
    }

    public double getLiftEncoder() {
        return liftEncoder.getDistance();
    }

    public boolean getLowerLimit() {
        return !liftLowerLimit.get();
    }

    public boolean getUpperLimit() {
        return !liftUpperLimit.get();
    }

    public double liftMin() {
        return 0;
    }

    public double liftMax() {
        return 1300;
    }

}
