package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.TheRobot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOpMode extends OpMode {
    private TheRobot robot;

    @Override
    public void init() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);
    }

    @Override
    public void init_loop(){

    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        robot.onStop();
        robot.reset();
    }
}
