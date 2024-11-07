package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.TheRobot;

@Autonomous(name="AutoPark")
public class AutoParkOpMode extends OpMode {

    private TheRobot robot;
    @Override
    public void init() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);

        telemetry.addData("Robot Status", "Initializing AutoPark OpMode");
    }

    @Override
    public void start() {
        super.start();
    }


    @Override
    public void loop() {

    }
}
