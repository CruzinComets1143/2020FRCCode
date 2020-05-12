/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutonMove;
import frc.robot.commands.Move;
import frc.robot.commands.SampleAuton;
import frc.robot.subsystems.Coathanger;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stopper;
import frc.robot.subsystems.Wheel;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.AnalogInput;

//import com.revrobotics.ColorSensorV3;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static Coathanger mCoatHanger = new Coathanger();
  public static Wheel mWheel = new Wheel();
  public static Shooter mShooter = new Shooter();
  public static Intake mIntake=new Intake();
  public static RobotContainer m_robotContainer;
  public static DriveTrain mDriveTrain = new DriveTrain();
  public static Stopper mStopper = new Stopper();

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 mColorSensor=new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  public static String colorString;
  public static String neededColor;

  public static GenericHID.Hand driver_hand;
  private int autonStyle;

  private static final AnalogInput distanceSensor = new AnalogInput(0);
 
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    SmartDashboard.putNumber("Auton Style", 0);
    SmartDashboard.putString("Color we need:", "Unknown");
    SmartDashboard.putBoolean("Correct color?", false);
    SmartDashboard.putBoolean("Shoot? ;)",false);

    m_robotContainer = new RobotContainer();
    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();
    
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);  
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    Color detectedColor = mColorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    neededColor=(SmartDashboard.getString("Color we need:", "Unknown")).toLowerCase();
    if (match.color == kBlueTarget) {
      colorString = "blue";
    } 
    else if (match.color == kRedTarget) {
      colorString = "red";
    } 
    else if (match.color == kGreenTarget) {
      colorString = "green";
    } 
    else if (match.color == kYellowTarget) {
      colorString = "yellow";
    } 
    else {
      colorString = "Unknown";
    }
    SmartDashboard.putString("Current Color", colorString);

    //This does not display as intended in the future, it is just a test
    if((Robot.neededColor.equals("blue")&&Robot.colorString.equals("red"))||(Robot.neededColor.equals("red")&&Robot.colorString.equals("blue"))||(Robot.neededColor.equals("green")&&Robot.colorString.equals("yellow"))||(Robot.neededColor.equals("yellow")&&Robot.colorString.equals("green"))){
    SmartDashboard.putBoolean("Correct color?", true);
    }
    else{
      SmartDashboard.putBoolean("Correct color?", false);
    }

    if(distanceSensor.getValue()*0.125<Constants.SHOOTING_MAX&&distanceSensor.getValue()*0.125>Constants.SHOOTING_MIN){
      SmartDashboard.putBoolean("Distance", true);
      }
      else{
        SmartDashboard.putBoolean("Distance", false);
      }
    SmartDashboard.putNumber("Distance from:",distanceSensor.getValue()*0.125);
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    
    autonStyle=(int)SmartDashboard.getNumber("Auton Style", 0);
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    new SampleAuton(autonStyle).schedule();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    /*if(autonStyle==0){
    if(m_Timer.get() < 2) {
      m_myRobot.driveCartesian(0, 0.5, 0);
    }
    else {
      m_myRobot.driveCartesian(0, 0, 0);
    }
  }
  else if(autonStyle==1){
    if(m_Timer.get() < 2) {
      m_myRobot.driveCartesian(0, -0.5, 0);
    }
    else {
      m_myRobot.driveCartesian(0, 0, 0);
    }
  }*/
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    new Move().schedule();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
    //Pretty Light for the distance sensor (just used color sensor to test it)
    
    //Distance sensor on the robot, what will he do
    //Value of the distance sensor in INCHES
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {

  }

  public static RobotContainer getContainer(){
    return m_robotContainer;
  }
}
