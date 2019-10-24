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
import org.usfirst.frc4534.DeepSpace2019.testing.LiftToHeight;

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
    public JoystickButton xButtonc1;
    public JoystickButton yButton;
    public JoystickButton leftBumper;
    public JoystickButton rightBumper;
    public JoystickButton select;
    public JoystickButton start;
    public JoystickButton leftJoystick;
    public Joystick joystick;
    public JoystickButton aButton2;
    public JoystickButton bButton2;
    public JoystickButton xButton2;
    public JoystickButton yButton2;
    public JoystickButton leftBumper2;
    public JoystickButton rightBumper2;
    public JoystickButton select2;
    public JoystickButton start2;
    public Joystick joystick2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        select = new JoystickButton(joystick, 7);
        select.whenPressed(new ToggleKablams());
        start = new JoystickButton(joystick, 8);
        start.whenPressed(new ToggleRocket());
        xButtonc1 = new JoystickButton(joystick, 3);
        xButtonc1.whenPressed(new TapeGroup());
        leftJoystick = new JoystickButton(joystick, 9);
        leftBumper = new JoystickButton(joystick, 5);
        rightBumper = new JoystickButton(joystick, 6);
        
        joystick2 = new Joystick(1);
        
        //aButton2 = new JoystickButton(joystick2, 1);
        //aButton2.whenPressed(new MoveVacuum(-1.0));
        bButton2 = new JoystickButton(joystick2, 2);
        bButton2.whenPressed(new ToggleRocket());
        yButton2 = new JoystickButton(joystick2, 4);
        yButton2.whenPressed(new ToggleHatch());
        xButton2 = new JoystickButton(joystick2, 3);
        xButton2.whenPressed(new MoveIntake(-1.0));
        xButton2.whenReleased(new MoveIntake(0.0));
        leftBumper2 = new JoystickButton(joystick2, 5);
        leftBumper2.whenPressed(new MoveIntake(-0.8));
        leftBumper2.whenReleased(new MoveIntake(0.0));
        rightBumper2 = new JoystickButton(joystick2, 6);
        rightBumper2.whenPressed(new MoveIntake(1.0));
        rightBumper2.whenReleased(new MoveIntake(0.0));
        start2 = new JoystickButton(joystick2, 8);
        start2.whenPressed(new ToggleHatchHook());

        // SmartDashboard Buttons

        SmartDashboard.putData("Lift mid", new LiftToHeight(715.0));
        SmartDashboard.putData("Lift low", new LiftToHeight(25.0));
        SmartDashboard.putData("Lift mid-low", new LiftToHeight(300.0));
        // SmartDashboard.putData("ChangeLEDMode", new ChangeLEDMode());
        //SmartDashboard.putData("CBT (Configure Bot (to) Target)", new AlignToTape());
        SmartDashboard.putData("Enable Demo Mode", new SetDemoMode(true));
        SmartDashboard.putData("Disable Demo Mode", new SetDemoMode(false));
        // SmartDashboard.putData("ExtendKablams", new ExtendKablams());
        // SmartDashboard.putData("ResetGyro", new ResetGyro());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getjoystick() {
        return joystick;
    }

    public Joystick getJoystick2() {
        return joystick2;
    } 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

