package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Config
@Autonomous(name="Testing Auto", group="Autonomous")
public class TestAutonomous extends LinearOpMode {
    private final Pose2d STARTING_POSITION = new Pose2d(12, 60+6, Math.PI);

    private final Vector2d TOKEN_POSITION_LEFT = new Vector2d(24, 36);
    private final Vector2d TOKEN_POSITION_CENTER = new Vector2d(12, 24);
    private final Vector2d TOKEN_POSITION_RIGHT = new Vector2d(0, 36);
    private final Vector2d PARKING_POSITION = new Vector2d(60, 60);

    private Vector2d TOKEN_POSITION = TOKEN_POSITION_CENTER;  //default to center, override with detected value if needed
    private Integer APRILTAG_VALUE = 2;  //default to center, override with detected value if needed
    @Override
    public void runOpMode() {
        Robot gRex = new Robot(hardwareMap, STARTING_POSITION);


        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

/*
        Actions.runBlocking(
                gRex.drive.actionBuilder(STARTING_POSITION)
                        .splineTo(TOKEN_POSITION, Math.PI) //deposit purple pixel
                        .endTrajectory()
                        .splineTo(new Vector2d(12, 36), Math.PI) //reverse so we don't move pixel
                        .splineToSplineHeading(new Pose2d(12, 48, 0), Math.PI)
                        .splineTo(PARKING_POSITION, 0) //park
                        .build()
        );
*/

        Actions.runBlocking(
                gRex.drive.actionBuilder(STARTING_POSITION)
                        .lineToY(TOKEN_POSITION.y)
                        .endTrajectory()
                        .lineToY(TOKEN_POSITION.y +12.0)
                        .build()
                );

        while(!isStopRequested()){}
    }
}
