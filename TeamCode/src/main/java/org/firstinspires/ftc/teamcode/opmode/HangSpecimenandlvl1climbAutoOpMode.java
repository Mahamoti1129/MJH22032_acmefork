package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.TheRobot;

@Autonomous(name="HangSpecimenandLvl1climb", group="Auto")
public class HangSpecimenandlvl1climbAutoOpMode extends CommandOpMode {

    private TheRobot robot;

    private final Pose2d START_POSITION = new Pose2d(-9, -63, Math.PI/2);

    @Override
    public void initialize() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);
        telemetry.addData("Robot Status", "Initializing Hang Specimen OpMode");

        schedule(new InstantCommand(() -> {
            robot.drivetrain.actionBuilder(START_POSITION)
                    .lineToY(-39)
                    .build();
        }));

        // raise arm, extend arm

        schedule(new InstantCommand(() -> {
            robot.drivetrain.actionBuilder(START_POSITION)
                    .lineToY(-33)
                    .build();
        }));

        // open claw
        // Retract arm, close claw, lower arm
        schedule(new InstantCommand(() -> {
            robot.drivetrain.actionBuilder(START_POSITION)
                    .lineToY(-36)
                    .lineToX(-36)
                    .lineToY(-12)
                    .turnTo(0)
                    .build();
        }));

        //raise arm
        //forward 9
        //lower arm
    }
}
