// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;


import frc.robot.RobotContainer;
//import frc.robot.Robot;
//import frc.robot.commands.*;


public class DriveBase extends SubsystemBase {
  /** Creates a new DriveBase. */

  WPI_TalonSRX leftTalon = RobotContainer.leftFrontTalon;
  WPI_TalonSRX rightTalon = RobotContainer.rightFrontTalon;
  WPI_VictorSPX leftVictor = RobotContainer.leftBackVictor;
  WPI_VictorSPX rightVictor = RobotContainer.rightBackVictor;
 
  double leftMotorSpeed = 0;
  double rightMotorSpeed = 0; 
 
  public DriveBase() {
    
  }

  public void JoystickInputs(Joystick rightJoystick, Joystick leftJoystick){
    leftMotorSpeed = leftJoystick.getY()*-1;//get values from joystick
    rightMotorSpeed = rightJoystick.getY();

    leftTalon.set(leftMotorSpeed);
    leftVictor.set(leftMotorSpeed);
    rightTalon.set(rightMotorSpeed);
    rightVictor.set(rightMotorSpeed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
