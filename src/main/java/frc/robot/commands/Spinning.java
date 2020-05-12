/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Spinning extends CommandBase {
  /**
   * Creates a new spinning.
   */
  public Spinning() {
    addRequirements(Robot.mWheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((Robot.neededColor.equals("blue")&&Robot.colorString.equals("red"))||(Robot.neededColor.equals("red")&&Robot.colorString.equals("blue"))||(Robot.neededColor.equals("green")&&Robot.colorString.equals("yellow"))||(Robot.neededColor.equals("yellow")&&Robot.colorString.equals("green"))){
      Robot.mWheel.endSpinning();
    }
    else{
      Robot.mWheel.setWheelSpeed();  
    }
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.mWheel.endSpinning();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
