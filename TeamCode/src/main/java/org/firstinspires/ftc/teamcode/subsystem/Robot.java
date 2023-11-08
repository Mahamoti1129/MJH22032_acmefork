package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    private MecanumDrive drivetrain;
    private Camera camera;

    public Robot(HardwareMap hardwareMap, Pose2d pose){
        drivetrain = new MecanumDrive(hardwareMap, pose);

    }
    public TrajectoryActionBuilder actionBuilder(Pose2d beginPose) {
        return drivetrain.actionBuilder(beginPose);
    }
}
