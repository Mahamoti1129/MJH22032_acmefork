package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.subsystem.Robot;

import java.util.Optional;

/** @noinspection unused*/
@Autonomous(name="Blue Backstage Auto", group="Autonomous")
public class BlueBackstageAutonomous extends LinearOpMode {

    private final Pose2d STARTING_POSITION = new Pose2d(12, 66, -Math.PI/2);
    private final Pose2d TOKEN_POSITION_LEFT = new Pose2d(24, 30, -Math.PI /4);
    private final Pose2d TOKEN_POSITION_CENTER = new Pose2d(18, 30, -Math.PI/2);
    private final Pose2d TOKEN_POSITION_RIGHT = new Pose2d(0, 36, -Math.PI * 5/2);
    private final Vector2d PARKING_POSITION = new Vector2d(66, 66);

    private Pose2d TOKEN_POSITION = TOKEN_POSITION_CENTER;  //default to center, override with detected value if needed
    private Integer APRILTAG_VALUE = 2;  //default to center, override with detected value if needed
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        Robot gRex = new Robot (hardwareMap, STARTING_POSITION);

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
            Optional<Recognition> oRec = gRex.camera.findTokenRecognition();
            if (oRec.isPresent()){
                if (oRec.get().getLeft() < 200){
                    TOKEN_POSITION = TOKEN_POSITION_LEFT;
                }else {
                    TOKEN_POSITION = TOKEN_POSITION_CENTER;
                }

                telemetry.addData("token left: ", oRec.get().getLeft());
            }else {
                TOKEN_POSITION = TOKEN_POSITION_RIGHT;
            }

            telemetry.addData("token position: ", TOKEN_POSITION);
            telemetry.update();
        }

        Actions.runBlocking(
                gRex.drive.actionBuilder(STARTING_POSITION)
                        .splineToLinearHeading(TOKEN_POSITION, 0)
                        .setReversed(true)
                        .splineToLinearHeading(STARTING_POSITION, -Math.PI/2)
                        .setReversed(false)
                        .splineToLinearHeading(new Pose2d(PARKING_POSITION, -Math.PI/2), 0d)
                        .build()
        );
    }
}
