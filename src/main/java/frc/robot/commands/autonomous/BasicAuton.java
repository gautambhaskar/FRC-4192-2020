/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drive.DriveForDistance;
import frc.robot.commands.drive.DriveSetDistance;
import frc.robot.commands.drive.DriveSetTime;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class BasicAuton extends SequentialCommandGroup {
  /**
   * Creates a new BasicAuton.
   */
  private Drivetrain m_drive;

  public BasicAuton(Drivetrain drive) { // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new DriveForDistance(drive, 1), new DriveSetTime(drive, 2));
    m_drive = drive;
  }
}