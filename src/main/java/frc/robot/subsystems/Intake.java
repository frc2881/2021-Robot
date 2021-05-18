package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{

    private CANSparkMax intake;

    public boolean intakeStart = true;
    public boolean intakeStop = true;
    
    public Intake(){

        intake = new CANSparkMax(10, MotorType.kBrushless);
            intake.setInverted(false);
            intake.setIdleMode(IdleMode.kBrake);
    }

    public void controlIntake(double speed){
        intake.set(speed);
    }

    public boolean getIntakeStop(){
        return intakeStop;
    }

    @Override
    public void periodic(){

    }
}
