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
 public void periodic() { }

}
