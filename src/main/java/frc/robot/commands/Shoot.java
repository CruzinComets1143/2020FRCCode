/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Shoot extends CommandBase {
  //Determines what the button is using this command for
  // 0 --> Taking balls in
  // 1 --> Pushing balls out
  // 2 --> Shooting the ball
  private int mStyle;
  private Timer t=new Timer();
  /**
   * Creates a new Shoot.
   */
  public Shoot(int style) {
    mStyle = style;
    addRequirements(Robot.mShooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    t.reset();
    t.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(mStyle == 0) {
      Robot.mIntake.takeInBalls();
    }
    else if(mStyle == 1) {
      Robot.mIntake.pushOutBalls();
      Robot.mShooter.spinShooterBack();
    }
    else {
      Robot.mShooter.setShooterSpeed();
      if(t.get()>4.5){
        SmartDashboard.putBoolean("Shoot? ;)",true);
      }
      else{
        SmartDashboard.putBoolean("Shoot? ;)",false);
      }
    }
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.mShooter.endIntake();
    Robot.mIntake.endIntake();
    SmartDashboard.putBoolean("Shoot? ;)",false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
