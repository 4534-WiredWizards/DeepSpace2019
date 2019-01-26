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

import org.usfirst.frc4534.DeepSpace2019.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4534.DeepSpace2019.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton aButton;
    public JoystickButton bButton;
    public JoystickButton xButton;
    public JoystickButton yButton;
    public JoystickButton leftBumper;
    public JoystickButton rightBumper;
    public Joystick joystick;
    public Joystick joystick2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        // rightBumper = new JoystickButton(joystick, 6);
        // rightBumper.whileHeld(new EjectBall());
        // leftBumper = new JoystickButton(joystick, 5);
        // leftBumper.whileHeld(new IntakeBall());
        // yButton = new JoystickButton(joystick, 4);
        // yButton.whenPressed(new BezierCurve());
        xButton = new JoystickButton(joystick, 3);
        xButton.whenPressed(new ToggleRocket());
        bButton = new JoystickButton(joystick, 2);
        bButton.whenPressed(new ChangeLEDMode());
        aButton = new JoystickButton(joystick, 1);
        aButton.whenPressed(new EjectHatch());

        joystick2 = new Joystick(1);
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        // SmartDashboard.putData("IntakeBall", new IntakeBall());
        // SmartDashboard.putData("EjectBall", new EjectBall());
        SmartDashboard.putData("ToggleRocket", new ToggleRocket());
        SmartDashboard.putData("EjectHatch", new EjectHatch());
        SmartDashboard.putData("LiftWithJoystick", new LiftWithJoystick());
        SmartDashboard.putData("RaiseToHeight", new RaiseToHeight());
        SmartDashboard.putData("ChangeLEDMode", new ChangeLEDMode());
        // SmartDashboard.putData("DriveStraightDistance", new DriveStraightDistance());
        // SmartDashboard.putData("DriveStraightTimed", new DriveStraightTimed());
        // SmartDashboard.putData("BezierCurve", new BezierCurve());
        SmartDashboard.putData("AlignToTape", new AlignToTape());
        SmartDashboard.putData("ExtendKablam", new ExtendKablam());
        SmartDashboard.putData("ExtendKabloom", new ExtendKabloom());
        // SmartDashboard.putData("TurnAngle", new TurnAngle());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getjoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

