/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SampleAuton extends SequentialCommandGroup {
  /**
   * Creates a new SampleAuton.
   */
  public SampleAuton(int style) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    //super(new );

    //I made shoot, then move the generic command.
    if(style==0){
      addCommands(new ParallelCommandGroup(new AutonShoot(), new AutonIntake()), new ParallelCommandGroup(new AutonShoot(), new AutonIntake()), new ParallelCommandGroup(new AutonShoot(), new AutonIntake()), new AutonMove(0.5,0.5));
    }
    else if(style==1){
      addCommands(new AutonMove(0.5,0.5));
    //addCommands(new AutonMove(2, 0.5), new ParallelCommandGroup(new AutonShoot(), new AutonIntake()));
    }
    //changed speed to 0 so the robot wont move, can test shoot
    // else if(style==2){
    // addCommands(new AutonMove(2, 0), new ParallelCommandGroup(new AutonShoot(), new AutonIntake()));
    // }
  
}
}
