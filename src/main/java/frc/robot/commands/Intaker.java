// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Carrier;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Intaker extends CommandBase {

  private final Carrier m_carrier;

  public Intaker(Carrier subsystem_Carrier) {

    m_carrier = subsystem_Carrier;
    addRequirements(subsystem_Carrier);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double OJoyVal = RobotContainer.c_XboxControler.getRightX();

    /*
     * if(OJoyVal> 0.1 )
     * {
     * m_carrier.move(ControlMode.PercentOutput, OJoyVal);
     * }
     * else{
     * m_carrier.move(ControlMode.PercentOutput, OJoyVal );
     * }
     */

    m_carrier.move(ControlMode.PercentOutput, -OJoyVal / 3);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_carrier.move(ControlMode.PercentOutput, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
