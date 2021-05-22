package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeStop extends CommandBase {
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private Intake intake;

    public IntakeStop(Intake intake) {
        this.intake = intake;
    
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        boolean intakeStop = intake.getIntakeStop();
        intakeStop =! intakeStop;
    }

}
