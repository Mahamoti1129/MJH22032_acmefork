package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous(name="Blue Backstage Auto", group="Autonomous")
public class BlueBackstageAutonomous extends LinearOpMode {

    private final Pose2d STARTING_POSITION = new Pose2d(-65,12, Math.toRadians(90));
    @Override
    public void runOpMode() throws InterruptedException {
//        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        Robot gRex = new Robot (hardwareMap, STARTING_POSITION);

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

        gRex.drive.actionBuilder(STARTING_POSITION)
                .lineToX(3) // get off of wall
                .lineToY(24) // park backstage
                .build();
    }
}
