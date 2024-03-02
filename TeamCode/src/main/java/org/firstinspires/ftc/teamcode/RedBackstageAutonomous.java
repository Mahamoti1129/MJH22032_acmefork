package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.subsystem.Robot;

import java.util.Optional;

@Autonomous(name="Red Backstage Auto", group="Autonomous")
public class RedBackstageAutonomous extends LinearOpMode {
    private final Pose2d STARTING_POSITION = new Pose2d(12, -66, Math.PI/2);
    private final Pose2d PARKING_POSITION = new Pose2d(72, -66, Math.PI/2);
    private final Pose2d TOKEN_POSITION_LEFT = new Pose2d(0, -36, Math.PI * 3/4);
    private final Pose2d TOKEN_POSITION_CENTER = new Pose2d(18, -30, -Math.PI/2);
    private final Pose2d TOKEN_POSITION_RIGHT = new Pose2d(24, -36, Math.PI /4);
    private Pose2d TOKEN_POSITION = TOKEN_POSITION_CENTER;  //default to center, override with detected value if needed

    @Override
    public void runOpMode() throws InterruptedException {
        Robot gRex = new Robot(hardwareMap, STARTING_POSITION);

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
                        .splineToLinearHeading(TOKEN_POSITION, 0d)
                        .setReversed(true)
                        .splineToLinearHeading(STARTING_POSITION, 0d)
                        .setReversed(false)
                        .splineToLinearHeading(PARKING_POSITION, 0d)
                        .build()
        );
    }
}
