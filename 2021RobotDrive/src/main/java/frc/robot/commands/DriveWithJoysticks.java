// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.DoubleSupplier;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveWithJoysticks extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive m_Drive;
  private final DoubleSupplier m_xSpeed;
  private final DoubleSupplier m_zRotation;
  /**
   * Creates a new ExampleCommand.
   *
   * @param Drive The subsystem used by this command.
   */
  public DriveWithJoysticks(Drive subsystem, DoubleSupplier xSpeed, DoubleSupplier zRotation) {
    m_Drive = subsystem;
    m_xSpeed = xSpeed;
    m_zRotation = zRotation;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.arcadeDrive(m_xSpeed.getAsDouble(), m_zRotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
