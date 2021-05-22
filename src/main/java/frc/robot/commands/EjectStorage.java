/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.BallStorage;
import frc.robot.subsystems.BallStorage.StorageDirection;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class EjectStorage extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private BallStorage ballStorage;
    double speed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public EjectStorage(BallStorage ballStorage) {
    
    this.ballStorage = ballStorage;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ballStorage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ballStorage.storing(speed, StorageDirection.INTAKE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ballStorage.storing(0, StorageDirection.INTAKE);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
