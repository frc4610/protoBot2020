// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carrier;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class Pivot extends CommandBase {
  private final Intake m_intake;
  private final Carrier m_carrier;
  double speed;
  double EncoderVal;

  public Pivot(Intake subsystem_Driver, Carrier subsystem_Carrier) {
    m_intake = subsystem_Driver;
    m_carrier = subsystem_Carrier;
    addRequirements(subsystem_Driver);
    addRequirements(subsystem_Carrier);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double triggerValueL = RobotContainer.driver.getRawAxis(2);
    double triggerValueR = RobotContainer.driver.getRawAxis(3);
    EncoderVal = m_intake.m_encoder.getPosition();

    if (triggerValueL > 0.1) {
      m_intake.move(-triggerValueL);
    } else if (triggerValueR > 0.1) {
      m_intake.move(triggerValueR);

    }
    if (EncoderVal > 20) {
      m_carrier.move(ControlMode.PercentOutput, Constants.INTAKE_BALL_SPEED);

    } else {
      m_carrier.move(ControlMode.PercentOutput, 0);

    }
    SmartDashboard.putNumber("triggerValueL", triggerValueL);
    SmartDashboard.putNumber("triggerValueR", triggerValueR);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.move(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
