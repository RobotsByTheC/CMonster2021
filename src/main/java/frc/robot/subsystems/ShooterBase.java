// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Spark;

public class ShooterBase extends SubsystemBase {

public static Spark leftSpark = RobotContainer.shooterLeftSpark;
public static Spark rightSpark = RobotContainer.shooterRightSpark;
public static Spark ConveyorSpark = RobotContainer.conveyorSpark;
  /** Creates a new ShooterBase. */
  public ShooterBase() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ShootBallOn(){
    leftSpark.set(1);
    rightSpark.set(1);
  }
  public void ShootBallOff(){
    leftSpark.set(0);
    rightSpark.set(0);
  }
  
  public void ConveyorStart(){
    ConveyorSpark.set(1);
  }
  public void ConveyorStop(){
    ConveyorSpark.set(0);
  }
}
