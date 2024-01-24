package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous(name="Red Backstage Auto", group="Autonomous")
public class RedBackstageAutonomous extends LinearOpMode {
    private final Pose2d STARTING_POSITION = new Pose2d(12, -60, Math.PI/2);
    private final Vector2d PARKING_POSITION = new Vector2d(72, -60);
    @Override
    public void runOpMode() throws InterruptedException {
        Robot gRex = new Robot(hardwareMap, STARTING_POSITION);

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

        Actions.runBlocking(
                gRex.drive.actionBuilder(STARTING_POSITION)
                        .splineToLinearHeading(new Pose2d(PARKING_POSITION, Math.PI/2), 0d)
                        .build()
        );
    }
}
