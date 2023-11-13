package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous(name="Blue Audience Auto", group="Autonomous")
public class BlueAudienceAutonomous extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
 //       MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        Robot gRex = new Robot(hardwareMap, new Pose2d(0, 0, 0));

        // replaces waitForStart() and enables camera searching before runtime
        while (!isStarted() && !isStopRequested()){
        }

        gRex.actionBuilder(new Pose2d(0, 0, 0))
                .lineToX(3 + 24) // forward to park opposite side of backdrop from backstage bots
                .turn(-90) // turn backstage
                .lineToX(24) // park backstage
                .build();
    }
}
