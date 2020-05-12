/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Stop extends CommandBase {
  //true = shut
  //false = open
  private boolean style;
  private final static Timer mTimer = new Timer();
  /**
   * Creates a new Stop.
   */
  public Stop(boolean style) {
    this.style = style;
    addRequirements(Robot.mStopper);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Stop initialized");
    mTimer.reset();
    mTimer.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(style) {
      Robot.mStopper.shut();
    }
    else {
      Robot.mStopper.open();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.mStopper.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if(mTimer.get() > 0.1) {
    //   return true;
    // }
    return false;
   }
}
