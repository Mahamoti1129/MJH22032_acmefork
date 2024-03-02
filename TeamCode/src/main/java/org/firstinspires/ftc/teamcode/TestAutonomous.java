package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

/** @noinspection unused*/
@Autonomous(name="Test Autonomous", group="Autonomous")
@Config
public class TestAutonomous extends LinearOpMode {

    public static class PARAMS {
        public Double STARTING_POSITION_X = 0d;
        public Double STARTING_POSITION_Y = 0d;
        public Double STARTING_POSITION_HEADING = 0d;
        public Double TOKEN_X = 36d;
        public Double TOKEN_Y = 12d;
        public Double TOKEN_HEADING = Math.PI/4;
        public Double TOKEN_TANGENT = Math.PI/4;
    }
    public static PARAMS Params = new PARAMS();

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        Robot gRex = new Robot (hardwareMap, new Pose2d(Params.STARTING_POSITION_X, Params.STARTING_POSITION_Y, Params.STARTING_POSITION_HEADING));

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

        Actions.runBlocking(
                gRex.drive.actionBuilder(gRex.drive.pose)
                        .splineToSplineHeading(new Pose2d(Params.TOKEN_X, Params.TOKEN_Y, Params.TOKEN_HEADING), Params.TOKEN_TANGENT)
                        .build()
        );
    }
}
