/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.ControlIntake;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;

import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_Subsystem = new Drive();
  private final Intake m_intake = new Intake();

  XboxController m_driverController = new XboxController(1);

  private final DriveWithJoysticks m_autoCommand = new DriveWithJoysticks(

    m_Subsystem, 
    () -> 
    m_driverController.getRawAxis(1),
    () ->
    -m_driverController.getRawAxis(2));

  //private final IntakeStop m_IntakeStop = new IntakeStop(m_intake);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  

  m_Subsystem.setDefaultCommand(m_autoCommand);
  //intake.setDefaultCommand();

  /*m_Subsystem.setDefaultCommand(
    new RunCommand(
      () -> 
        m_Subsystem.arcadeDrive(
            m_driverController.getRawAxis(1),
            m_driverController.getRawAxis(2)),
            m_Subsystem));*/
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_driverController, Button.kBumperRight.value)
      .whenPressed(() -> m_Subsystem.setMaxOutput(0.5))
      .whenReleased(() -> m_Subsystem.setMaxOutput(1));
    
    new JoystickButton(m_driverController, Button.kB.value)
      .whileHeld(new ControlIntake(m_intake));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}
