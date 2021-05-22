package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlIntake extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private Intake intake;
  
    public ControlIntake(Intake intake) {
        this.intake = intake;

        addRequirements(intake);
    }

    @Override
    public void execute() {
    
        double m_speed;
        if(intake.intakeStop)
            m_speed = 0;
        else
            m_speed = -0.5;

        intake.controlIntake(m_speed);
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
