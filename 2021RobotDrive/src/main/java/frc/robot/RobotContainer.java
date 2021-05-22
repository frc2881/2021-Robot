// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_Drive = new Drive();
  private final Intake m_Intake = new Intake();
  XboxController driver = new XboxController(0);

  //private final DriveWithJoysticks m_DriveWithJoysticks = new DriveWithJoysticks(
   // m_Drive, 
    //() ->
    //driver.getRawAxis(1), 
    //() ->
    //driver.getRawAxis(2)
    //);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    m_Drive.setDefaultCommand(
      //m_DriveWithJoysticks
      new RunCommand(
        () ->
          m_Drive.arcadeDrive(
            getDriverLeftY(), 
            getDriverRightX()
          ),
        m_Drive)  
    );
    m_Intake.setDefaultCommand(
      new RunCommand(
        () -> {
          if (getDriverL1() > 0){
            if((getDriverL1() > 0.5)){
              m_Intake.setSpeed(-0.5);
            }else{
              m_Intake.setSpeed(-getDriverL1());
            }
          } else if ((getDriverL2() > 0) && (getDriverL1() == 0)){
            if((getDriverL2() > 0.5)){
              m_Intake.setSpeed(0.5);
            }else{
              m_Intake.setSpeed(getDriverL2());
            }
          } else if ((getDriverL1() == 0) && (getDriverL2() == 0)){
            m_Intake.setSpeed(0);
          }
        },
          m_Intake)
          
    );

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(driver, 3)
      .whenHeld(
        new RunCommand(
          () ->
            m_Intake.setSpeed(0.5),
          m_Intake)
        ); //square button to intake
    new JoystickButton(driver, 1)      
      .whenHeld(
        new RunCommand(
          () ->
            m_Intake.setSpeed(-0.5),
          m_Intake)
      ); //circle button to reverse intake
  }
  public double getDriverLeftY(){
    return driver.getRawAxis(1);
  }
  public double getDriverRightX(){
    return driver.getRawAxis(2);
  }
  public double getDriverL1(){
    return (((driver.getRawAxis(3)) + 1)/2);
  }
  public double getDriverL2(){
    return (((driver.getRawAxis(4)) + 1)/2);
  }
}
