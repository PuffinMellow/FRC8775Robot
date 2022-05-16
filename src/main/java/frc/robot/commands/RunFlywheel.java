package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class RunIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter shooterSubsystem;
  private double stopTime;
  private double RPM;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunIntake(Shooter subsystem, double maxTime, double rpm) {
    this.stopTime = System.getTimeMillis() + maxTime;
    this.shooterSubsystem = subsystem;
    this.RPM = RPM;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      this.shooterSubsystem.setRPM(this.RPM);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      this.shooterSubsystem.setRPM(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(System.getTimeMillis() > this.stopTime) {
      return true;
    } else {
      return false;
    }
  }
}
