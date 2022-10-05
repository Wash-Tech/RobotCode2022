package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

    private CANSparkMax extender;
    private CANSparkMax lifter;
    
    public Climber() {

        extender = new CANSparkMax(11, MotorType.kBrushed);
 
        extender.restoreFactoryDefaults();  
        extender.setInverted(false);
        extender.setIdleMode(IdleMode.kBrake);

        lifter = new CANSparkMax(12, MotorType.kBrushed);
 
        lifter.restoreFactoryDefaults();  
        lifter.setInverted(false);
        lifter.setIdleMode(IdleMode.kBrake);
    }

    public void extend(double speed) {
        extender.set(speed);
        lifter.set(0);
    }

    public void lift(double speed) {
        lifter.set(speed);
        extender.set(0);
    }
}
