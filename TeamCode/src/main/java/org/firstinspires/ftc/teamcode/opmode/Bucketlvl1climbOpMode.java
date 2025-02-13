package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.TheRobot;

@Autonomous(name="BucketLvl1climb", group="Auto")
public class Bucketlvl1climbOpMode extends CommandOpMode {

    private TheRobot robot;

    private final Pose2d START_POSITION = new Pose2d(-9, -63, Math.PI/2);

    @Override
    public void initialize() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);
        telemetry.addData("Robot Status", "Initializing Hang Specimen OpMode");

        schedule(new InstantCommand(() -> {
            robot.drivetrain.actionBuilder(START_POSITION)
                    .lineToY(-60)
                    .turnTo(Math.PI)
                    .lineToX(-57)
                    .build();
        }));

        //raise arm, extend arm, open claw
        //retract arm, close claw, lower arm
        schedule(new InstantCommand(() -> {
            robot.drivetrain.actionBuilder(START_POSITION)
                    .turnTo(Math.PI/2)
                    .lineToY(-12)
                    .turnTo(0)

                    .build();
        }));

        //raise arm
        //forward 9
        //lower arm





    }
}
