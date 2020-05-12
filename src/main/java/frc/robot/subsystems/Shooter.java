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

public class Shooter extends SubsystemBase {
  
  PWMVictorSPX shooter_motor = new PWMVictorSPX(Constants.SHOOTER_MOTOR_ID);
  public Shooter() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setShooterSpeed(){
    shooter_motor.set(Constants.SHOOTER_SPEED);
  }
  public void spinShooterBack(){
    shooter_motor.set(-Constants.SHOOTER_SPEED);
  }

  public void endIntake() {
    
    shooter_motor.setSpeed(0);
  }
  
}
