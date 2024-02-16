package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous(name="Blue Audience Auto", group="Autonomous")
public class BlueAudienceAutonomous extends LinearOpMode {

    private final Pose2d STARTING_POSITION = new Pose2d(-36, 72, -Math.PI/2);
    private final Vector2d PARKING_POSITION = new Vector2d(60, 12);
    @Override
    public void runOpMode() throws InterruptedException {
        Robot gRex = new Robot(hardwareMap, STARTING_POSITION);

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

        Actions.runBlocking(
                gRex.drive.actionBuilder(STARTING_POSITION)
                        .lineToY(PARKING_POSITION.y)
                        .turnTo(0)
                        .lineToX(PARKING_POSITION.x)
                        .build()
        );
    }
}
