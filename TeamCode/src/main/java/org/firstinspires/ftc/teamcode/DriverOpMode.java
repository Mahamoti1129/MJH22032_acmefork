package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@TeleOp(name="Driver Mode", group="TeleOp")
public class DriverOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot gRex = new Robot(hardwareMap, new Pose2d(0, 0, 0));
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        waitForStart();

        while (opModeIsActive()) {
            gRex.drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x
                    ),
                    -gamepad1.right_stick_x
            ));

/*
            if (gamepad1.left_bumper){
                gRex.droneLauncher.launch();
            }
*/

            if (gamepad2.left_stick_x > 0){
                gRex.arm.setTargetUp(gamepad2.left_stick_x);
            }else if (gamepad2.left_stick_x < 0){
                gRex.arm.setTargetDown(gamepad2.left_stick_x);
            }
            gRex.arm.moveArm();

            if (gamepad2.right_bumper){
                gRex.arm.moveWristUp();
            }else if (gamepad2.left_bumper){
                gRex.arm.moveWristDown();
            }

            gRex.drive.updatePoseEstimate();

            telemetry.addData("x", gRex.drive.pose.position.x);
            telemetry.addData("y", gRex.drive.pose.position.y);
            telemetry.addData("heading", gRex.drive.pose.heading);

            telemetry.addData("left trigger", gamepad2.left_trigger);
            telemetry.addData("right trigger", gamepad2.right_trigger);
            telemetry.addData("arm position", gRex.arm.getCurrentPosition());

            telemetry.addData("left bumper", gamepad2.left_bumper);
            telemetry.addData("right bumper", gamepad2.right_bumper);
            telemetry.update();
        }
    }
}
