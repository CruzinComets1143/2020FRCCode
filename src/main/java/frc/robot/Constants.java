/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Little Easter Egg to test Github functionally
    //It is going Swimmingly
//Motor ID's
    //Drive Train Motors
    public static final int MOTOR_LEFT_BACK_ID = 1;
	public static final int MOTOR_RIGHT_FRONT_ID = 2;
	public static final int MOTOR_RIGHT_BACK_ID = 3;
    public static final int MOTOR_LEFT_FRONT_ID = 0;

    //Shooter Motors
    public static final int INTAKE_MOTOR_ID = 5;
    public static final int SHOOTER_MOTOR_ID = 4;
    //Shooter Motor speeds
    public static final double INTAKE_SPEED = 1; 
    public static final double BELT_SPEED = 0.75;
    public static final double SHOOTER_SPEED = -0.6; 

    //CoatHanger Motors
    public static final int WINCH_MOTOR_ID = 9; //Set Later ;)
    public static final int PIPE_MOTOR_ID = 8; //Set Later ;)
    //Winch Motor Speed
    public static final double PIPE_SPEED = 1; //Set Later ;)
    //Hook Motor Speed
    public static final double WINCH_SPEED=0.5; //Set Later ;)

    //Wheel Motors
    public static final int WHEEL_MOTOR_ID = 7; 
    //Wheel Speed 
    public static final double WHEEL_SPEED = 0.5; 
    
    //Stopper Motor
    public static final int STOPPER_MOTOR_ID = 6;
    //Stopper Motor Speed
    public static final double STOPPER_SPEED = 0.5;

    //Controller 
    public static final int DRIVER_CONTROLLER = 0;
    public static XboxController driverController = new XboxController(DRIVER_CONTROLLER);
    public static final int AUX_CONTROLLER = 1;
    public static XboxController auxController=new XboxController(AUX_CONTROLLER);
    
	public static final int LEFT_STICK_X = 0;
	public static final int RIGHT_STICK_Y = 5;
	public static final int X_BUTTON = 3;
	public static final int RIGHT_TRIGGER = 3;
    public static final int LEFT_TRIGGER = 2;
    public static final int LEFT_STICK_Y = 1;

    //min&max for distance
    public static final double SHOOTING_MAX=268;
    public static final double SHOOTING_MIN=258;
}
