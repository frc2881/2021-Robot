package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlIntake extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    double speed;
    private Intake intake;
  
    public ControlIntake(Intake intake, double speed) {
        
        this.speed = speed;

        this.intake = intake;

        addRequirements(intake);
    }

    @Override
    public void execute() {
    
        if(intake.intakeStop)
            speed = 0;
        else
            speed = -0.5;

        System.out.println(speed);
        intake.controlIntake(speed);
    }

    @Override
    public void end(boolean interrupted) {
        intake.controlIntake(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
