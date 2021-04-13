// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotContainer;

public class ControlWheelBase extends SubsystemBase {

  public static WPI_TalonSRX ControlWheelTalon = RobotContainer.controlWheelTalon;
  /** Creates a new ControlWheelBase. */
  public ControlWheelBase() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ControlWheelStart(){
    ControlWheelTalon.set(0.75);
  }
  
  public void ControlWheelStop(){
    ControlWheelTalon.set(0);
  }
}
