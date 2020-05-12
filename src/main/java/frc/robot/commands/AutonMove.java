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

public class AutonMove extends CommandBase {
  private static final Timer m_Timer = new Timer();
  private double mEndTime;
  private double mSpeed;
  /**
   * Creates a new AutonMove.
   */
  public AutonMove(double time, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.mDriveTrain);
    mEndTime = time;
    mSpeed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {        
    m_Timer.reset();
    m_Timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.mDriveTrain.setAutonSpeed(0, mSpeed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.mDriveTrain.stopAll();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_Timer.get() > mEndTime) {
      return true;
    }
    return false;
  }
}
