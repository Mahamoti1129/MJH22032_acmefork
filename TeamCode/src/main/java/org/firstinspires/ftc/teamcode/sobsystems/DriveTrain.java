package org.firstinspires.ftc.teamcode.sobsystems;

//import com.arcrobotics.ftclib.SubsystemBase;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveTrain extends SubsystemBase {

    private Motor frontLeftDrive;
    private Motor frontRightDrive;
    private Motor backLeftDrive;
    private Motor backRightDrive;
    private GamepadEx driveController;
    private Telemetry xtelemetry;
    private double controllerLeftY;
    private double controllerRightX;
 public DriveTrain(HardwareMap hardwaremap, Telemetry htelemetry, GamepadEx controller1) {
     frontLeftDrive = new Motor(hardwaremap, "frontleft");
     frontRightDrive = new Motor(hardwaremap, "frontright");
     backLeftDrive = new Motor(hardwaremap, "backleft");
     backRightDrive = new Motor(hardwaremap, "backright");

     frontLeftDrive.setRunMode(Motor.RunMode.RawPower);
     frontRightDrive.setRunMode(Motor.RunMode.RawPower);
     backLeftDrive.setRunMode(Motor.RunMode.RawPower);
     backRightDrive.setRunMode(Motor.RunMode.RawPower);
     xtelemetry = htelemetry;
     driveController = controller1;
 }

 @Override
 public void periodic() {
    getJoystickValues();
    drive(controllerLeftY, controllerRightX);
 }
 private void getJoystickValues() {
     controllerRightX = driveController.getRightX();
     controllerLeftY = driveController.getLeftY();
 }
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

}
