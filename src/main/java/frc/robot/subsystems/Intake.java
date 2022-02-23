// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Intake extends SubsystemBase {
  CANSparkMax m_intakeArm; //the motor that moves the arm up and down id 5
  TalonFX m_intakingMotor; //the motor on the fromt to take in the ball with id 10
  public RelativeEncoder m_encoder;
  /** Creates a new Intake. */
  public Intake() {
    m_intakeArm = new CANSparkMax(5 , MotorType.kBrushless);
    m_intakingMotor = new TalonFX(10);
    m_encoder = m_intakeArm.getEncoder();
  }
  public void move(double speed){
    //intakeArm.set(speed)
    m_intakeArm.set(speed);
    if(m_encoder.getPosition() > 20){}
  }
  public void moveUp(double speed){
    m_intakeArm.set(speed);
    m_intakingMotor.set(ControlMode.PercentOutput, 0);
  }
  public void moveDown(double speed){
    m_intakeArm.set(-speed);
   // m_intakingMotor.set(ControlMode.PercentOutput, m_encoder.getPosition()* 2);
  }
  public void stop(){
    m_intakeArm.set(0);
    m_intakingMotor.set(ControlMode.PercentOutput, m_encoder.getPosition()/100);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   SmartDashboard.putNumber("encoderPosition", m_encoder.getPosition());





  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}
