// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.index;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Globals;
import frc.robot.Constants.shooterPID;
import frc.robot.subsystems.Index;

public class AutoIndex extends CommandBase {
  /** Creates a new AutoIndex. */
  private Index index;
  private boolean alreadyRun;
  private Timer timer = new Timer();
  private int numBalls;
  private int ballsShot;

  public AutoIndex(Index m_index, int m_numBalls) {
    index = m_index;
    alreadyRun = false;
    numBalls = m_numBalls;
    ballsShot = 0;

    addRequirements(m_index);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Globals.shooterSpeed > shooterPID.shooterSpeedMinimum && alreadyRun == false) {
      index.run(Constants.indexSpeed);
      timer.start();
      alreadyRun = true;
      ballsShot++;
    } else if (Globals.shooterSpeed > shooterPID.shooterSpeedMinimum && alreadyRun == true
        && timer.get() > Constants.indexRunTime) {
      index.run(0);
      alreadyRun = false;
    } else if (Globals.shooterSpeed < shooterPID.shooterSpeedMinimum) {
      alreadyRun = false;
      index.run(0);
    } else {
      index.run(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    index.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (numBalls == -1) {
      return false;
    } else {
      return ballsShot >= numBalls;
    }
  }
}
