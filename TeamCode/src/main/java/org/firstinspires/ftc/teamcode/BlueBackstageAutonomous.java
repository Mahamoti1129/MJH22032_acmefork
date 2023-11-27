package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous(name="Blue Backstage Auto", group="Autonomous")
public class BlueBackstageAutonomous extends LinearOpMode {

    private final Pose2d STARTING_POSITION = new Pose2d(12, 60, -Math.PI/2);

    private final Vector2d TOKEN_POSITION_LEFT = new Vector2d(24, 36);
    private final Vector2d TOKEN_POSITION_CENTER = new Vector2d(12, 24);
    private final Vector2d TOKEN_POSITION_RIGHT = new Vector2d(0, 36);
    private final Vector2d PARKING_POSITION = new Vector2d(60, 60);

    private Vector2d TOKEN_POSITION = TOKEN_POSITION_CENTER;  //default to center, override with detected value if needed
    private Integer APRILTAG_VALUE = 2;  //default to center, override with detected value if needed
    @Override
    public void runOpMode() throws InterruptedException {
        Robot gRex = new Robot (hardwareMap, STARTING_POSITION);

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
            //TODO: locate pixel or token, save values for purple/yellow pixel deposits
        }

        Actions.runBlocking(
                gRex.drive.actionBuilder(STARTING_POSITION)
                        .strafeTo(TOKEN_POSITION) //deposit purple pixel
                        .endTrajectory()
                        .strafeTo(new Vector2d(12, 36)) //reverse so we don't move pixel
                        .splineToSplineHeading(new Pose2d(12, 48, 0), 0)
                        //TODO: deposit yellow pixel on backdrop
                        .splineTo(PARKING_POSITION, 0) //park
                        .build()
        );
    }
}
