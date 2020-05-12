/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  MecanumDrive m_myRobot = new MecanumDrive(new PWMVictorSPX(Constants.MOTOR_LEFT_FRONT_ID), new PWMVictorSPX(Constants.MOTOR_LEFT_BACK_ID), 
  new PWMVictorSPX(Constants.MOTOR_RIGHT_FRONT_ID), new PWMVictorSPX(Constants.MOTOR_RIGHT_BACK_ID));
  GenericHID.Hand driver_hand;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setSpeed() {
    m_myRobot.driveCartesian(0.5*Constants.driverController.getX(driver_hand.kLeft),
                             -0.5* Constants.driverController.getY(driver_hand.kLeft),
                             0.5* Constants.driverController.getX(driver_hand.kRight));
  }
  public void stopAll() {
    m_myRobot.driveCartesian(0, 0, 0);
  }
  public void setAutonSpeed(double a, double b, double c) {
    m_myRobot.driveCartesian(a, b, c);
  }
}
