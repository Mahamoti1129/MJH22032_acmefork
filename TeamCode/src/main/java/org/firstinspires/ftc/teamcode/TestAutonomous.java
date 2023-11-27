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
    private static final Pose2d START_POSITION = new Pose2d(0, 0, 0);
    @Override
    public void runOpMode() {
        Robot gRex = new Robot(hardwareMap, START_POSITION);


        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }
        Actions.runBlocking(
                gRex.drive.actionBuilder(START_POSITION)
                        .strafeTo(new Vector2d(60, 60))
                    .build()
            );

        while(!isStopRequested()){}
    }
}
