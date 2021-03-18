// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import  edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotContainer;

public class ClimberBase extends SubsystemBase {

  public static Spark ElevatorMotor = RobotContainer.elevatorSpark;

  
  /** Creates a new ClimberBase. */
  public ClimberBase() {

  }
  public void ElevatorUp(){
    ElevatorMotor.set(1);
  }
  
  public void ElevatorDown(){
    ElevatorMotor.set(-1);
  }
  
  public void ElevatorStop(){
    ElevatorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
