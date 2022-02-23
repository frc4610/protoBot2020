// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
//import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.commands.Pivot;
//import java.lang.LiveStackFrame.PrimitiveSlot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import com..CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class Carrier extends SubsystemBase {
  private TalonFX CarrierM_Motor;

  public Carrier() {
    CarrierM_Motor = new TalonFX(10);
    CarrierM_Motor.setInverted(false);
   
  }


  public void move(ControlMode mode, double speed){

    //intakeArm.set(speed);

    CarrierM_Motor.set(mode, speed);
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



