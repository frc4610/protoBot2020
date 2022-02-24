// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class driveTrain extends SubsystemBase {
  private TalonFX driveTrainL;
  private TalonFX driveTrainR;

  public driveTrain() {
    driveTrainL = new TalonFX(4);
    driveTrainR = new TalonFX(3);
    driveTrainL.setInverted(false);

  }

  public void move(ControlMode mode, double speedL, double speedR) {
    driveTrainL.set(mode, speedL);
    driveTrainR.set(mode, speedR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}
