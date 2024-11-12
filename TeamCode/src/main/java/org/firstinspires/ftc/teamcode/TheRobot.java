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
    private DriveTrain drivetrain;

    private GamepadEx controller1;
    private GamepadEx controller2;
    public static Telemetry telemetry;

    public TheRobot(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry2) {
        telemetry = telemetry2;
        controller1 = new GamepadEx(gamepad1);
        controller2 = new GamepadEx(gamepad2);
        drivetrain = new DriveTrain(hardwareMap, telemetry, controller1);
    }
        public void onStop() {
            drivetrain.stopDrive();
        }
}
