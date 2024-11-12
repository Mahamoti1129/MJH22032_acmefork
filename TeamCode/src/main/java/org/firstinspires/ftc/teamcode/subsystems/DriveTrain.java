package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MecanumDrive;

public class DriveTrain extends SubsystemBase {

    private MecanumDrive mecanumDrive;
    private GamepadEx driveController;
    private Telemetry telemetry;
 public DriveTrain(HardwareMap hardwaremap, Telemetry telemetry, GamepadEx controller1) {
     this.telemetry = telemetry;
     driveController = controller1;

     mecanumDrive = new MecanumDrive(hardwaremap, new Pose2d(0.0d, 0.0d, 0.0d));
 }



 @Override
 public void periodic() {
     telemetry.addData("mecaum drive", mecanumDrive.toString());
     mecanumDrive.setDrivePowers(new PoseVelocity2d(
             new Vector2d(
                     driveController.getLeftY(),
                     driveController.getLeftX()
             ),
             driveController.getRightX()
     ));
 }
/*
 private void drive(double forwardPower, double turnPower) {
     double leftPower = forwardPower + turnPower;
     double rightPower = forwardPower - turnPower;//might be inverted
     double maxPower = Math.max(leftPower, rightPower);
     if (maxPower > 1) {
         leftPower /= maxPower;
         rightPower /= maxPower;

     }
     frontLeftDrive.set(leftPower);
     backLeftDrive.set(leftPower);
     frontRightDrive.set(rightPower);
     backRightDrive.set(rightPower);

 }
 public void stopDrive() {
     frontLeftDrive.set(0.0);
     backLeftDrive.set(0.0);
     frontRightDrive.set(0.0);
     backRightDrive.set(0.0);
 }
*/

    public void stopDrive() {
        mecanumDrive.stop();
    }
}
