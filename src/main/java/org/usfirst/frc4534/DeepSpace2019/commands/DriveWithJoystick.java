// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4534.DeepSpace2019.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4534.DeepSpace2019.Robot;

/**
 *
 */
public class DriveWithJoystick extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveWithJoystick() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.driveTrain.resetMotorControllers();
        //Robot.driveTrain.setInversions();
        //Robot.driveTrain.setToFollow();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double TarsSpeed = Robot.oi.joystick.getY() * 0.4;
        if (0.05 > TarsSpeed && TarsSpeed > -0.05) {
            TarsSpeed = 0;
        }
        double TarsRotation = Robot.oi.joystick.getRawAxis(4) * 0.4;
        if (0.05 > TarsRotation && TarsRotation > -0.05) {
            TarsRotation = 0;
        }
        Robot.driveTrain.ArcadeDrive(-TarsSpeed, TarsRotation);
        // Robot.driveTrain.setShifter(Robot.oi.leftJoystick.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.driveTrain.TankDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.driveTrain.TankDrive(0,0);
    }
}
