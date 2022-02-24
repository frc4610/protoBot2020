// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.led.FireAnimation;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.IntakeArmDown;
import frc.robot.commands.IntakeArmStop;
import frc.robot.commands.IntakeArmUp;
import frc.robot.commands.Intaker;
import frc.robot.commands.Pivot;
import frc.robot.commands.movement;
import frc.robot.subsystems.Carrier;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final static driveTrain s_driveTrain = new driveTrain();
  private final static movement c_movement = new movement(s_driveTrain);
  private final static Intake s_intake = new Intake();
  private final static Carrier s_Carrier = new Carrier();
  private final static Pivot c_Pivot = new Pivot(s_intake, s_Carrier);
  private final static Intaker c_Intaker = new Intaker(s_Carrier);
  private final IntakeArmUp c_IntakeUp = new IntakeArmUp(s_intake);
  private final IntakeArmDown c_IntakeDown = new IntakeArmDown(s_intake);
  private final IntakeArmStop c_IntakeStop = new IntakeArmStop(s_intake);
  private final LEDSubsystem m_ledSubsystem = new LEDSubsystem();
  // controller inputs
  // public static XboxController Driver = new XboxController(0);
  public static Joystick driver = new Joystick(0);
  public static JoystickButton driverXButton = new JoystickButton(driver, 3);
  public static JoystickButton driverAButton = new JoystickButton(driver, 1);
  public static JoystickButton driverBButton = new JoystickButton(driver, 2);
  public static JoystickButton driverYButton = new JoystickButton(driver, 4);
  public static JoystickButton driverLeftBumper = new JoystickButton(driver, 5);
  public static JoystickButton driverRightBumper = new JoystickButton(driver, 6);
  public static JoystickButton driverLeftJoyButton = new JoystickButton(driver, 9);

  // public static Joystick Operator = new Joystick(1);
  // public static Trigger LeftTrigger = new Trigger(Driver);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    driverLeftBumper.whileHeld(c_IntakeUp);
    driverRightBumper.whileHeld(c_IntakeDown);

    configureButtonBindings();

    // m_ledSubsystem.setStatusLEDColor(255, 255, 255, 1);
    // m_ledSubsystem.setLEDStripColor(0, 255, 0);

    m_ledSubsystem.setAnimation(new FireAnimation(1, 0.5, LEDSubsystem.LED_STRIP_COUNT, 1, 1));

  }

  public static void startDrive() {
    c_movement.schedule(true);
    // c_Pivot.schedule(true);
    // c_Intaker.schedule(true);
    // s_intake.schedule(true);
    // s_intakeArm.schedule(true);
  }

  private void configureButtonBindings() {
    // JoystickButton buttonB = new JoystickButton(Driver, 2);
    // buttonB.whenActive(new IntakeArmDown(s_intake, Driver)).whenInactive(new
    // IntakeArmUp(s_intake, Driver));
    s_intake.setDefaultCommand(c_IntakeStop);

  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return c_movement;
  }
}
