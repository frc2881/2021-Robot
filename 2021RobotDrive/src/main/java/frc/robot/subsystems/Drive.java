// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private CANSparkMax leftFront;
    private CANSparkMax leftRear;
    private CANSparkMax rightFront;
    private CANSparkMax rightRear;
    private DifferentialDrive differentialDrive1;
    private Spark spotlight; 

    public Drive(){
      
      leftFront = new CANSparkMax(1, MotorType.kBrushless);
      leftFront.setInverted(false);
      leftFront.setIdleMode(IdleMode.kBrake);

      leftRear = new CANSparkMax(2, MotorType.kBrushless);
      leftRear.setInverted(false);
      leftRear.setIdleMode(IdleMode.kBrake);

      leftRear.follow(leftFront);

      rightFront = new CANSparkMax(3, MotorType.kBrushless);
      rightFront.setInverted(false);
      rightFront.setIdleMode(IdleMode.kBrake);

      rightRear = new CANSparkMax(4, MotorType.kBrushless);
      rightRear.setInverted(false);
      rightRear.setIdleMode(IdleMode.kBrake);

      rightRear.follow(rightFront);

      differentialDrive1 = new DifferentialDrive(leftFront, rightFront);
      addChild("Differential Drive 1", differentialDrive1);
      differentialDrive1.setSafetyEnabled(true);
      differentialDrive1.setExpiration(0.1);
      differentialDrive1.setMaxOutput(1.0);

    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  
  public void arcadeDrive(double xSpeed, double zRotation){
    differentialDrive1.arcadeDrive(xSpeed, -zRotation, true);
  }
}
