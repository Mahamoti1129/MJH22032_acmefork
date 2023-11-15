package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous(name="Testing Auto", group="Autonomous")
public class TestAutonomous extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot gRex = new Robot(hardwareMap, new Pose2d(0, 0, 0));

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

        gRex.drive.actionBuilder(new Pose2d(0, 0, 90))
                .lineToX(24) // get off of wall
                .build();
    }
}
