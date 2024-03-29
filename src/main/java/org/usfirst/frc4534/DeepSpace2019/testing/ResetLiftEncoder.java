/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4534.DeepSpace2019.testing;

import org.usfirst.frc4534.DeepSpace2019.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetLiftEncoder extends Command {
    public ResetLiftEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.redesignedLift);
    }


    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.redesignedLift.resetLiftEncoder();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(Robot.redesignedLift.getLiftEncoder() > 1.0) {
            return false; 
        }
        else return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
