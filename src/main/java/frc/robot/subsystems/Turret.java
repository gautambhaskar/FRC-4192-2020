/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /**
   * Creates a new Turret.
   */

  // Motor
  private final CANSparkMax turretMotor = new CANSparkMax(Constants.index, MotorType.kBrushless);

  public Turret() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Set Turret Speed
  public void turn(double turretSpeed) {
    turretMotor.set(turretSpeed);
  }
}
