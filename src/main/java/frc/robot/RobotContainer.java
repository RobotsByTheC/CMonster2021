// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*; 
import frc.robot.subsystems.*; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);



 //declared and initallizes talons and victors for drive train 
    public static WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(2);
    public static WPI_VictorSPX leftBackVictor = new WPI_VictorSPX(3);
    public static WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(4); 
    public static WPI_VictorSPX rightBackVictor = new WPI_VictorSPX(5);

    public static WPI_TalonSRX intakeTalon = new WPI_TalonSRX(8); 

    //Sparks
   public static Spark shooterLeftSpark = new Spark(2);
    public static Spark shooterRightSpark = new Spark(3);
    public static Spark conveyorSpark = new Spark (4);
    public static Spark elevatorSpark = new Spark (5);
    public static Spark leftAgitatorSpark = new Spark (6); 
    public static Spark rightAgitatorSpark = new Spark (7); 

    //Compressors
    public static Compressor robotCompressor;

    //Solenoids
    public static DoubleSolenoid intakeSolenoid = new DoubleSolenoid(0,1); 


  //Initialzes subsystems in RobotContainer
  public static DriveBase driveBase;
  public static ClimberBase climberBase; 
  public static ShooterBase shooterBase; 
  public static IntakeBase intakeBase; 

//Initializes commands in RobotContainer
  public static DriveWithJoystick driveWithJoystick; 


  public static Joystick rightJoystick; 
  public static Joystick leftJoystick; 
  public static Joystick logiTech;

  public static JoystickButton shootBall; 
  public static JoystickButton conveyorBelt; 
  public static JoystickButton elevatorUp; 
  public static JoystickButton elevatorDown; 
  public static JoystickButton intakeIn; 
  public static JoystickButton intakeOut; 
  public static JoystickButton intakeUp; 
  public static JoystickButton intakeDown; 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */


  public RobotContainer() {
//Joysticks and JoystickButtons 
leftJoystick = new Joystick(0);
rightJoystick = new Joystick(1);
logiTech = new Joystick(2);

shootBall = new JoystickButton (logiTech, 0);
conveyorBelt = new JoystickButton (logiTech, 3);
elevatorUp = new JoystickButton (logiTech, 7);
elevatorDown = new JoystickButton (logiTech, 5);
intakeIn = new JoystickButton(logiTech, 4);
intakeOut = new JoystickButton(logiTech, 6); 
intakeDown = new JoystickButton(logiTech, 2);
intakeUp = new JoystickButton (logiTech, 1); 


driveBase = new DriveBase();
driveWithJoystick = new DriveWithJoystick();
CommandScheduler.getInstance().setDefaultCommand(driveBase, driveWithJoystick);


shootBall.whileHeld(new ShootBall());
shootBall.whenReleased(new StopBall());
conveyorBelt.whileHeld(new ConveyorStart());
conveyorBelt.whenReleased(new ConveyorStop());
elevatorUp.whileHeld(new ElevatorUp());
elevatorUp.whenReleased(new ElevatorStop());
elevatorDown.whileHeld(new ElevatorDown());
elevatorDown.whenReleased(new ElevatorStop());
intakeIn.whileHeld(new IntakeStart());
intakeIn.whenReleased(new IntakeStop());
intakeOut.whileHeld(new IntakeStartOut());
intakeOut.whenReleased(new IntakeStop());
intakeUp.whenPressed(new IntakeSolenoidUp());
intakeDown.whenPressed(new IntakeSolenoidDown());



    // Configure the button bindings
    configureButtonBindings();
  }





  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static Joystick getRightJoystick(){
    return rightJoystick;
  }

  public static Joystick getLeftJoystick(){
    return leftJoystick;
  }

  public static Joystick getLogiTech(){
    return logiTech; 
  }

 /* public static Joystick getLogitech(){
    return logitech;
  }*/
}
