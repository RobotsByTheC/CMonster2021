// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotContainer;

public class IntakeBase extends SubsystemBase {

  public static WPI_TalonSRX IntakeMotor = RobotContainer.intakeTalon;
  public static DoubleSolenoid IntakeSolenoid = RobotContainer.intakeSolenoid; 
 // public static Spark LeftAgitatorSpark = RobotContainer.leftAgitatorSpark;
 // public static Spark RightAgitatorSpark = RobotContainer.rightAgitatorSpark;
  
  /** Creates a new IntakeBase. */
  public IntakeBase() {
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void IntakeStartIn(){
    IntakeMotor.set(0.75);
  //  LeftAgitatorSpark.set(1);
  //  RightAgitatorSpark.set(1);
  }
  
  public void IntakeStartOut(){
    IntakeMotor.set(-0.75);
  }
  
  public void IntakeStop(){
    IntakeMotor.set(0);
  //  LeftAgitatorSpark.set(0);
    //RightAgitatorSpark.set(0);
  }
  
  public void intakeSolenoidUp(){
    
    IntakeSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  
  public void intakeSolenoidDown(){
    IntakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  
}
