// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drive m_drive = new Drive();
  private final Arm1 m_arm1 = new Arm1();
  private final Arm2 m_arm2 = new Arm2();

  // Commands
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final JoystickDrive JoystickDrive = new JoystickDrive(m_drive);

  double DriverX, DriverY;

  final static Joystick drStick = new Joystick(Constants.dr_stick);
  final JoystickButton drA = new JoystickButton(drStick, Constants.drA);
  final JoystickButton drB = new JoystickButton(drStick, Constants.drB);
  final JoystickButton drY = new JoystickButton(drStick, Constants.drY);
  final JoystickButton drX = new JoystickButton(drStick, Constants.drX);
  final JoystickButton drLT = new JoystickButton(drStick, Constants.drY);
  final JoystickButton drRT = new JoystickButton(drStick, Constants.drX);
  final JoystickButton drLB = new JoystickButton(drStick, Constants.drLB);
  final JoystickButton drRB = new JoystickButton(drStick, Constants.drRB);
  final static Joystick opStick = new Joystick(Constants.op_stick);
  final JoystickButton op1 = new JoystickButton(opStick, Constants.op1);
  final JoystickButton op2 = new JoystickButton(opStick, Constants.op2);
  final JoystickButton op3 = new JoystickButton(opStick, Constants.op3);
  final JoystickButton op4 = new JoystickButton(opStick, Constants.op4);
  final JoystickButton op5 = new JoystickButton(opStick, Constants.op5);
  final JoystickButton op6 = new JoystickButton(opStick, Constants.op6);
  final JoystickButton op7 = new JoystickButton(opStick, Constants.op7);
  final JoystickButton op8 = new JoystickButton(opStick, Constants.op8);
  final JoystickButton op9 = new JoystickButton(opStick, Constants.op9);
  final JoystickButton op10 = new JoystickButton(opStick, Constants.op10);
  final JoystickButton op11 = new JoystickButton(opStick, Constants.op11);
  final JoystickButton op12 = new JoystickButton(opStick, Constants.op12);
  final JoystickButton op13 = new JoystickButton(opStick, Constants.op13);
  final JoystickButton op14 = new JoystickButton(opStick, Constants.op14);
  final JoystickButton op15 = new JoystickButton(opStick, Constants.op15);
  final JoystickButton op16 = new JoystickButton(opStick, Constants.op16);
  final JoystickButton op17 = new JoystickButton(opStick, Constants.op17);
  final JoystickButton op18 = new JoystickButton(opStick, Constants.op18);
  final JoystickButton op19 = new JoystickButton(opStick, Constants.op19);
  final JoystickButton op20 = new JoystickButton(opStick, Constants.op20);
  final JoystickButton op21 = new JoystickButton(opStick, Constants.op21);
  final JoystickButton op22 = new JoystickButton(opStick, Constants.op22);
  final JoystickButton op23 = new JoystickButton(opStick, Constants.op23);
  final JoystickButton op24 = new JoystickButton(opStick, Constants.op24);
  final JoystickButton op25 = new JoystickButton(opStick, Constants.op25);
  final JoystickButton op26 = new JoystickButton(opStick, Constants.op26);
  final JoystickButton op27 = new JoystickButton(opStick, Constants.op27);
  final JoystickButton op28 = new JoystickButton(opStick, Constants.op28);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drive.setDefaultCommand(JoystickDrive);
    CameraServer.startAutomaticCapture();
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //drA.whileHeld(new RunClimber(m_climber, -1.0));
    //drY.whileHeld(new RunClimber(m_climber, 1.0));
    //drLB.whileHeld(new RunShwoopShooter(m_shoot));  // shoot
    //drRB.whileHeld(new RunIntake(m_intake, 0.75));  // run intake
    op1.whileHeld(new Arm1Up(m_arm1));
    op6.whileHeld(new Arm1Dn(m_arm1));
    op4.whileHeld(new Arm2Up(m_arm2));
    op9.whileHeld(new Arm2Dn(m_arm2));

    //op7.whenPressed( new RunParascope(m_limelight, false));

    //op11.whenPressed(new RunArm(s_arm, Constants.armVertical)); // Arm vertical
    //op12.whenPressed(new RunArm(s_arm, Constants.armDown)); // intake level
    //op13.whenPressed(new RunArm(s_arm, Constants.armDown)); // arm down for intake
    //op14.whenPressed(new IncArm(s_arm, 0)); // last shoot level
    //op15.whenPressed(new RunArm(s_arm, Constants.armHome));  // Arm inside boundaries
    //op16.whenPressed(new RunArm(s_arm, Constants.arm20ft)); // range 20 ft - for high shoot
    //op17.whileHeld(new RunIntake(m_intake, 0.75));
    //op18.whileHeld(new RunIntake(m_intake, -0.65)); // intake backwards
    //op19.whileHeld(new RunShwoopShooter(m_shoot, 0.8));
    //op19.whileHeld(new RunShwoopShooter(m_shoot));
    // move arm to last shoot position then fire
    //op19.whileHeld(new RunShwoopShooter(m_shoot));

    //op20.whileHeld(new LimelightAim(m_drive, m_limelight));   // aim robot with limelight
    //op21.whileHeld(new RunShwoopShooter(m_shwoop, m_shoot, 0.9));
    //op22.whenPressed(new IncShoot(m_shoot, 0.03));
    //op23.whenPressed(new IncShoot(m_shoot, -0.03));
    //op24.whenPressed(new StopArm(s_arm));   // arm stops right away
    //op25.whenPressed(new RunArm(s_arm, s_arm.jogPos));
    //op26.whenPressed(new IncArm(s_arm, -4));
    //op27.whenPressed(new IncArm(s_arm, 4));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static double DriverY() {
    return drStick.getRawAxis(1);
  }

  public static double DriverX() {
    return drStick.getRawAxis(4);
  }

}
