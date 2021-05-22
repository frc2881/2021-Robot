package frc.robot.commands;

import frc.robot.subsystems.BallStorage;
import frc.robot.subsystems.BallStorage.StorageDirection;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class EjectStorage extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private BallStorage ballStorage;
    
    double speed;
  
    public EjectStorage(BallStorage ballStorage) {
    
        this.ballStorage = ballStorage;
    
        addRequirements(ballStorage);
    }

    @Override
    public void execute() {
        ballStorage.storing(speed, StorageDirection.INTAKE);
    }

    @Override
    public void end(boolean interrupted) {
        ballStorage.storing(0, StorageDirection.INTAKE);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
