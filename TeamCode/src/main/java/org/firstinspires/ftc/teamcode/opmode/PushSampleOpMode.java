package org.firstinspires.ftc.teamcode.opmode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.TheRobot;
import org.firstinspires.ftc.teamcode.commands.LongParkOnlyCommand;
import org.firstinspires.ftc.teamcode.commands.PushSampleCommand;

@Autonomous(name="PushSampleOnly", group="Auto")
public class PushSampleOpMode extends CommandOpMode {

    private TheRobot robot;

    @Override
    public void initialize() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);
        telemetry.addData("Robot Status", "Initializing AutoPark OpMode");

        schedule(new PushSampleCommand(robot.drivetrain));
    }
}
