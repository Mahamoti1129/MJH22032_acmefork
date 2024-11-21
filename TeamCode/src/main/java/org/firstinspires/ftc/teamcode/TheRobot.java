package org.firstinspires.ftc.teamcode;
/*
in command line, run: adb connect 192.168.43.1:5555
to check that it is connected, run: adb devices -l
password for driver hub is mjheaglebots
*/

import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TheRobot extends Robot {
    public DriveTrain drivetrain;

    public GamepadEx driveController;
    public GamepadEx controller2;
    public Telemetry telemetry;

    public TheRobot(HardwareMap hardwareMap, Gamepad driveController, Gamepad gamepad2, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.driveController = new GamepadEx(driveController);
        this.controller2 = new GamepadEx(gamepad2);
        this.drivetrain = new DriveTrain(hardwareMap, telemetry, this.driveController);
    }
    public void onStop() {
            drivetrain.stopDrive();
        }
}
