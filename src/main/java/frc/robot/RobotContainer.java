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
import frc.robot.commands.Movement;
import frc.robot.subsystems.Carrier;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.driveTrain;
import frc.robot.utils.XboxControllerExtended;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
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
  private final static Movement c_movement = new Movement(s_driveTrain);
  private final static Intake s_intake = new Intake();
  private final static Carrier s_Carrier = new Carrier();
  private final static Pivot c_Pivot = new Pivot(s_intake, s_Carrier);
  private final static Intaker c_Intaker = new Intaker(s_Carrier);
  private final static IntakeArmUp c_IntakeUp = new IntakeArmUp(s_intake);
  private final static IntakeArmDown c_IntakeDown = new IntakeArmDown(s_intake);
  private final static IntakeArmStop c_IntakeStop = new IntakeArmStop(s_intake);
  private final static LEDSubsystem c_ledSubsystem = new LEDSubsystem();
  public final static XboxControllerExtended c_XboxControler = new XboxControllerExtended(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    new Button(c_XboxControler::getLeftBumper)
        .whenPressed(c_IntakeUp);
    new Button(c_XboxControler::getRightBumper)
        .whenPressed(c_IntakeDown);

    configureButtonBindings();

    // c_ledSubsystem.setStatusLEDColor(255, 255, 255, 1);
    // c_ledSubsystem.setLEDStripColor(0, 255, 0);

    c_ledSubsystem.setAnimation(new FireAnimation(1, 0.5, LEDSubsystem.LED_STRIP_COUNT, 1, 1));

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
