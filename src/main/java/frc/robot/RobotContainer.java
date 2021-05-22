package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.BallStorage.*;


import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    XboxController driverController = new XboxController(1);

    private final Drive drive = new Drive();
    private final Intake intake = new Intake();
    private final BallStorage ballStorage = new BallStorage();

    private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks(
        drive, 
        () -> driverController.getRawAxis(1),
        () -> -driverController.getRawAxis(2));

    public RobotContainer() {
    
        configureButtonBindings();
  

    drive.setDefaultCommand(driveWithJoysticks);
        /*intake.setDefaultCommand();

        m_Subsystem.setDefaultCommand(
            new RunCommand(
                () -> m_Subsystem.arcadeDrive(
                          m_driverController.getRawAxis(1),
                          m_driverController.getRawAxis(2)),
                          m_Subsystem));*/
    }

    private void configureButtonBindings() {
        new JoystickButton(driverController, Button.kBumperRight.value)
            .whenPressed(() -> drive.setMaxOutput(0.5))
            .whenReleased(() -> drive.setMaxOutput(1));
    
        new JoystickButton(driverController, Button.kBumperLeft.value)
            .whileHeld(new ControlIntake(intake, 0.5));

        new JoystickButton(driverController, Button.kBumperRight.value)
            .whileHeld(new ControlAlign(ballStorage, BeltAlignment.LEFT, BeltDirection.CENTER));
    }

}
