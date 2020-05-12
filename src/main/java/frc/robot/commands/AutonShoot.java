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

public class AutonShoot extends CommandBase {
  //Determines what the button is using this command for
  // 0 --> Taking balls in
  // 1 --> Pushing balls out
  // 2 --> Shooting the ball
  private static final Timer m_Timer = new Timer();
  /**
   * Creates a new Shoot.
   */
  public AutonShoot() {
    addRequirements(Robot.mShooter);
    // Use addRequirements() here to declare subsystem dependencies.
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
      Robot.mShooter.setShooterSpeed();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.mShooter.endIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_Timer.get() > 4) {
      return true;
    }
    return false;
  }
}
