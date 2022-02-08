package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Arm2 extends SubsystemBase {
  TalonSRX winch = new TalonSRX(21);

  public Arm2() {
    winch.configFactoryDefault();
    winch.setInverted(false);
    winch.setNeutralMode(NeutralMode.Brake);
  }

  public void wnchDrive(double speed){
      winch.set(ControlMode.PercentOutput, speed * 0.5);
  }
}
