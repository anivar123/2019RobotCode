package robot.subsystems;  

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {

    private WPI_VictorSPX leftFront;
    private WPI_VictorSPX leftBack;
    private WPI_VictorSPX rightFront;
    private WPI_VictorSPX rightBack;

    private SpeedControllerGroup leftSpeedGroup; 
    private SpeedControllerGroup rightSpeedGroup;

    private DifferentialDrive driveType;

    public DriveTrain() {
        leftFront = new WPI_VictorSPX(0);
        leftBack = new WPI_VictorSPX(1);
        rightFront = new WPI_VictorSPX(2);
        rightBack = new WPI_VictorSPX(3);

        leftSpeedGroup = new SpeedControllerGroup(leftFront,leftBack);
        rightSpeedGroup = new SpeedControllerGroup(rightFront,rightBack);

        driveType = new DifferentialDrive(leftSpeedGroup,rightSpeedGroup);
    }

    public void tankDrive(double left, double right) {
        driveType.tankDrive(left, right);
    }

    public void arcadeDrive(double straight, double left, double right) { 
        leftSpeedGroup.set(straight + left - right);
        rightSpeedGroup.set (-(straight - left + right)); 
    }

    public void arcadeDrive(double speed, double rotation) {
        driveType.arcadeDrive(speed, rotation);
    }
}