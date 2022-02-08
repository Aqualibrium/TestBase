/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
//import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.networktables.*;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

//import edu.wpi.first.wpilibj.Compressor;
 /*
 * An example subsystem. You can replace with me with your own subsystem.
 */
 
public class Drive extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  double speed, steer, maxSpeed, lDrive, rDrive;
  //Compressor compressor = new Compressor(0);
  Solenoid shifter = new Solenoid(0, PneumaticsModuleType.CTREPCM, 0);
  //Solenoid shifter = new Solenoid(0);
  TalonSRX leftDr0 = new TalonSRX(12);
  TalonSRX rightDr0 = new TalonSRX(13);
  VictorSPX leftDr1 = new VictorSPX(10);
  VictorSPX rightDr1 = new VictorSPX(11);

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  //DoubleSolenoid Shifter = new DoubleSolenoid(0, 1);
 protected void initDefaultCommand() {
  // Set the default command for a subsystem here.
 }

  //run this method during robot init
  public Drive() {
    // start compressor
    //.start();
    rightDr0.configFactoryDefault();
    leftDr0.configFactoryDefault();
    leftDr1.configFactoryDefault();
    rightDr1.configFactoryDefault();

    // invert mtors as required to get them going in the same direction
    // this is dependent on the wiring to the motors
    rightDr0.setInverted(true);
    leftDr0.setInverted(true);
    rightDr1.setInverted(true);
    leftDr1.setInverted(false);

    // let the motors coast to a stop
    leftDr0.setNeutralMode(NeutralMode.Brake);
    rightDr0.setNeutralMode(NeutralMode.Brake);
    leftDr1.setNeutralMode(NeutralMode.Brake);
    rightDr1.setNeutralMode(NeutralMode.Brake);

    // dr1 follows dr0
    leftDr1.follow(leftDr0);
    rightDr1.follow(rightDr0);
  }
 
 public void ArcadeDrive(double speed, double steer) {
    // make speed exponential so control is sensitive at low end
    speed = speed * speed * speed * 0.7;
    steer = steer * steer * steer * 0.7;
    lDrive = speed - steer;
    leftDr0.set(ControlMode.PercentOutput, lDrive);
    rDrive = speed + steer;
    rightDr0.set(ControlMode.PercentOutput, rDrive);
  }

  // shifter is removed
 public void ShiftGears(boolean shift) {
    if (shift) {
        shifter.set(true);
    } else
        shifter.set(false);
  }
}