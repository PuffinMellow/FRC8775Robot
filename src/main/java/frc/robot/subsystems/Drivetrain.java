// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Sensor data management will be added once we recive the pigeon order.
public class Drivetrain extends SubsystemBase {
  //Robot objects
  private final WPI_VictorSPX myVictor1;
  private final WPI_VictorSPX myVictor2;
  private final WPI_VictorSPX myVictor3;
  private final WPI_VictorSPX myVictor4;
  private final MotorControllerGroup groupleft;
  private final MotorControllerGroup groupright;
  private DifferentialDrive robotDrive;

  //Driving varibles
  private double drivingTurnRate = 0;
  private double drivingSpeed = 0;

  //Sensor input varibles

  public ExampleSubsystem() {
    this.myVictor1 = new WPI_VictorSPX(Constants.drivetrain1);
    this.myVictor2 = new WPI_VictorSPX(Constants.drivetrain2);
    this.myVictor3 = new WPI_VictorSPX(Constants.drivetrain3);
    this.myVictor4 = new WPI_VictorSPX(Constants.drivetrain4);
    this.groupleft = new MotorControllerGroup(myVictor1, myVictor2);
    this.groupright = new MotorControllerGroup(myVictor3, myVictor4);
    this.robotDrive = new DifferentialDrive(groupright, groupleft);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    this.robotDrive.arcadeDrive(this.drivingSpeed, this.drivingTurnRate)
  }

  public void setSpeed(double speed){
    this.drivingSpeed = speed;
  }

  public void setTurnRate(double rate){
    this.drivingTurnRate = rate;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
