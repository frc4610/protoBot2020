// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
//import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.commands.Pivot;
//import java.lang.LiveStackFrame.PrimitiveSlot;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;



public class intakeArm extends SubsystemBase {
  private com.revrobotics.CANSparkMax intakeDriver;
  public RelativeEncoder m_Encoder; 
  public intakeArm() {
    intakeDriver = new CANSparkMax(5, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless);
    m_Encoder = intakeDriver.getEncoder();

  }
  public void move(double speed){

    //intakeArm.set(speed);

    intakeDriver.set(speed);
    if(m_Encoder.getPosition() > 20){
      

    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   SmartDashboard.putNumber("Encoder Position", m_Encoder.getPosition());
  /* if(m_Encoder =< -1){
      m_Encoder.reset;

    }*/

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  }



