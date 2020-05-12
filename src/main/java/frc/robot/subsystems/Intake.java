/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  PWMVictorSPX intake_motor = new PWMVictorSPX(Constants.INTAKE_MOTOR_ID);
  /**
   * Creates a new Intake.
   */
  public Intake() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void takeInBalls(){
    intake_motor.set(Constants.INTAKE_SPEED);
  }
  public void pushOutBalls() {
    intake_motor.setSpeed(-Constants.INTAKE_SPEED);
  }
  public void endIntake() {
    intake_motor.setSpeed(0);
  }
}
