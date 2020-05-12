/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class Coathanger extends SubsystemBase {
  PWMVictorSPX pipe_motor = new PWMVictorSPX(Constants.PIPE_MOTOR_ID);
  PWMVictorSPX winch_motor = new PWMVictorSPX(Constants.WINCH_MOTOR_ID);
  public Coathanger() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setPipeMotor(double speed) {
    pipe_motor.set(speed);
  }
  public void setWinchMotor(double speed) {
    winch_motor.set(speed);
  }
}
