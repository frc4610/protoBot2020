// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.driveTrain;
//import frc.robot.subsystems.driveTrain;
//import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Movement extends CommandBase {

  private final driveTrain m_driveTrain;

  public Movement(driveTrain subsystem_driveTrain) {

    m_driveTrain = subsystem_driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joyValueL = RobotContainer.c_XboxControler.getLeftY() / 5;
    double joyValueR = RobotContainer.c_XboxControler.getRightY() / 5;

    m_driveTrain.move(ControlMode.PercentOutput, joyValueL, -joyValueR);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.move(ControlMode.PercentOutput, 0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
