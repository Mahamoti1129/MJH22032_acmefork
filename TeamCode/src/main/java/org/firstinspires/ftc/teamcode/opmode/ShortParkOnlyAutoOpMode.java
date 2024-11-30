package org.firstinspires.ftc.teamcode.opmode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.TheRobot;
import org.firstinspires.ftc.teamcode.commands.LongParkOnlyCommand;
import org.firstinspires.ftc.teamcode.commands.ShortParkOnlyCommand;

@Autonomous(name="LongParkOnlyAuto")
public class ShortParkOnlyAutoOpMode extends CommandOpMode {

    private TheRobot robot;

    @Override
    public void initialize() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);
        telemetry.addData("Robot Status", "Initializing AutoPark OpMode");

        schedule(new ShortParkOnlyCommand(robot.drivetrain));
    }
}
