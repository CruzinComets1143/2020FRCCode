/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Shoot;
import frc.robot.commands.Spinning;
import frc.robot.commands.Stop;
import frc.robot.commands.Lifting;
import edu.wpi.first.wpilibj.XboxController.Button;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private GenericHID.Hand driver_hand;
  
  
  

  
  //Joystick gives you value -1 to 1 triggers give you 0 to 1
  
  // The robot's subsystems and commands are defined here...





  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //X Button will shoot
    JoystickButton x_button = new JoystickButton(Constants.auxController, Button.kX.value);
    x_button.whileHeld(new Shoot(2));
    //Y Color wheel spin
    JoystickButton y_button = new JoystickButton(Constants.auxController, Button.kY.value);
    y_button.whileHeld(new Spinning());
    //A Button will suck balls in
    JoystickButton a_button = new JoystickButton(Constants.auxController, Button.kA.value);
    a_button.whileHeld(new Shoot(0));
    //B Button will suck balls out
    JoystickButton b_button = new JoystickButton(Constants.auxController, Button.kB.value);
    b_button.whileHeld(new Shoot(1));
    //Right Bumper close stopper
    JoystickButton r_bumper_button = new JoystickButton(Constants.auxController, Button.kBumperRight.value);
    r_bumper_button.whileHeld(new Stop(true));
    //Left Bumper open stopper
    JoystickButton l_bumper_button = new JoystickButton(Constants.auxController, Button.kBumperLeft.value);
    l_bumper_button.whileHeld(new Stop(false));


    //X driver raises the pipe
    JoystickButton x_driver=new JoystickButton(Constants.driverController, Button.kX.value);
    x_driver.whileHeld(new Lifting(0));
    //B driver lowers the pipe
    new JoystickButton(Constants.driverController, Button.kB.value).whileHeld(new Lifting(1));
    //A driver pulls the winch(lifts the robot)
    JoystickButton a_driver=new JoystickButton(Constants.driverController, Button.kA.value);
    a_driver.whileHeld(new Lifting(2));
    //Y driver extends the winch
    new JoystickButton(Constants.driverController, Button.kY.value).whileHeld(new Lifting(3));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
