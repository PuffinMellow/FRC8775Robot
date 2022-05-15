package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Sensor data management will be added once we recive the pigeon order.
public class Intake extends SubsystemBase {
  //Robot objects
  private final CANSparkMax backConveyerMotor;
  private final CANSparkMax frontConveyerMotor;

  //Driving varibles
  private double intakeSpeed = 0;
  
  //Sensor input varibles

  public Intake() {
    this.backConveyerMotor = new CANSparkMax(Constants.backConveyer, MotorType.kBrushed);
    this.frontConveyerMotor = new CANSparkMax(constants.frontConveyer, MotorType.kBrushed);
  }

  public void setIntakeSpeed(double speed){
    this.intakeSpeed = speed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    this.backConveyerMotor.setSpeed(intakeSpeed);
    this.frontConveyerMotor.setSpeed(intakeSpeed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}