package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallStorage extends SubsystemBase{

    private CANSparkMax leftAlignBelt;
    private CANSparkMax rightAlignBelt;
    private CANSparkMax ballStorage;

    public enum StorageDirection{
        INTAKE, EJECT
    }
    
    public enum BeltAlignment{
        LEFT, RIGHT
    }

    public enum BeltDirection{
        CENTER, EJECT
    }
    
    public BallStorage(){

        leftAlignBelt = new CANSparkMax(9, MotorType.kBrushless);
            leftAlignBelt.setInverted(false);
            leftAlignBelt.setIdleMode(IdleMode.kBrake);

        rightAlignBelt = new CANSparkMax(8, MotorType.kBrushless);
            rightAlignBelt.setInverted(false);
            rightAlignBelt.setIdleMode(IdleMode.kBrake);

        ballStorage = new CANSparkMax(7, MotorType.kBrushless);
            ballStorage.setInverted(false);
            ballStorage.setIdleMode(IdleMode.kBrake);
    }

    public void storageAlignment(double speed, StorageDirection direction){
        if (direction == StorageDirection.EJECT){
            leftAlignBelt.set(0);
            rightAlignBelt.set(0);
        } else {
            leftAlignBelt.set(speed);
            rightAlignBelt.set(-speed);
        }
    }
    
    public void storing(double speed, StorageDirection direction){
        if (direction == StorageDirection.INTAKE)
            ballStorage.set(-speed);
        else
            ballStorage.set(speed);
    }

    public void aligning(double left, double right){
        leftAlignBelt.set(left);
        rightAlignBelt.set(right);
    }

    @Override
    public void periodic(){

    }
}
