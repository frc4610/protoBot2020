// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carrier;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class IntakeBall extends CommandBase {
  /** Creates a new IntakeBall. */
  private final Carrier m_Carrier;

  public IntakeBall(Carrier carrier) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Carrier = carrier;
    addRequirements(carrier);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Carrier.move(ControlMode.PercentOutput, 25);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
