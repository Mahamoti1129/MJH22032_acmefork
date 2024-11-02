package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.TheRobot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOpMode extends OpMode {
    private TheRobot robot;

    @Override
    public void init() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);

        telemetry.addData("Robot Status", "Initializing TeleOp OpMode");
    }

    @Override
    public void init_loop(){

    }

    @Override
    public void start() {
        telemetry.addData("Robot Status", "Running TeleOp OpMode");
    }

    @Override
    public void loop() {
        robot.run();
    }

    @Override
    public void stop() {
        telemetry.addData("Robot Status", "Stopping TeleOp OpMode");
        robot.onStop();
        robot.reset();
    }
}
