// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private CANSparkMax rightRearMC;
private CANSparkMax rightFrontMC;
private CANSparkMax leftRearMC;
private CANSparkMax leftFrontMC;
private MecanumDrive mecanumDrive1;
private AnalogGyro analogGyro1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
rightRearMC = new CANSparkMax(2, MotorType.kBrushless);
 
   
rightRearMC.setInverted(true);
rightRearMC.setIdleMode(IdleMode.kCoast);
  

rightFrontMC = new CANSparkMax(3, MotorType.kBrushless);
 

rightFrontMC.setInverted(true);
rightFrontMC.setIdleMode(IdleMode.kCoast);
  

leftRearMC = new CANSparkMax(5, MotorType.kBrushless);
 
   
leftRearMC.setInverted(false);
leftRearMC.setIdleMode(IdleMode.kCoast);
  

leftFrontMC = new CANSparkMax(4, MotorType.kBrushless);
 
   
leftFrontMC.setInverted(false);
leftFrontMC.setIdleMode(IdleMode.kCoast);
  

mecanumDrive1 = new MecanumDrive(leftFrontMC, leftRearMC,
rightFrontMC, rightRearMC);
 addChild("Mecanum Drive 1",mecanumDrive1);
 mecanumDrive1.setSafetyEnabled(true);
mecanumDrive1.setExpiration(0.1);
mecanumDrive1.setMaxOutput(1.0);


analogGyro1 = new AnalogGyro(0);
 addChild("AnalogGyro 1",analogGyro1);
 analogGyro1.setSensitivity(0.007);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
//deadband code, causes the code to ignore small joystick movements.
mecanumDrive1.setDeadband(.3);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**
     * Drive the robot according to the parameters
     * @param ySpeed forward and backward speed, forward is positive
     * @param xSpeed left and right speed, right is positive
     * @param zRotation rotating speed, clockwise is positive
     */
    public void driveRobot(double ySpeed, double xSpeed, double zRotation){
        //This MathUtil Code was copied from wpilib driveCartesian
        //The default driveCartesian doesn't apply the deadband to zRotation.
        //This code fixes that by applying it right before zRotation is passed to driveCartesian
        zRotation = MathUtil.applyDeadband(zRotation, 0.3);

        mecanumDrive1.driveCartesian(ySpeed, xSpeed, zRotation, analogGyro1.getAngle());
    }
}

