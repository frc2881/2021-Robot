package frc.robot.commands;

import frc.robot.subsystems.BallStorage;
import frc.robot.subsystems.BallStorage.BeltAlignment;
import frc.robot.subsystems.BallStorage.BeltDirection;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlAlign extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private BallStorage ballStorage;
    
    private BeltAlignment alignment;
    private BeltDirection direction;

    public ControlAlign(BallStorage ballStorage, BeltAlignment alignment, BeltDirection direction){

        this.ballStorage = ballStorage;
        this.alignment = alignment;
        this.direction = direction;

        addRequirements(ballStorage);
    }

    @Override
    public void execute(){
        if (direction == BeltDirection.CENTER){
            if (alignment == BeltAlignment.LEFT)
                ballStorage.aligning(0.5, 0);
            else
                ballStorage.aligning(0, 0.5);
        } else {
            if (alignment == BeltAlignment.LEFT)
                ballStorage.aligning(-0.5, 0);
            else
                ballStorage.aligning(0, -0.5);
        }
    }

    @Override
    public void end(boolean interrupted) {
        ballStorage.aligning(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}