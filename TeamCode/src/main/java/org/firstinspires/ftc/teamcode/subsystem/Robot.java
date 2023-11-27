package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public final MecanumDrive drive;
//TODO:    public final DroneLauncher droneLauncher;
    public final Camera camera;
    public static final Pose2d BLUE_AUDIENCE_START = new Pose2d(-36, 60, -Math.PI/2);
    public static final Pose2d RED_AUDIENCE_START = new Pose2d(-36, -60, Math.PI/2);
    public Robot(HardwareMap hardwareMap, Pose2d pose){
        drive = new MecanumDrive(hardwareMap, pose);
//TODO:        droneLauncher = new DroneLauncher(hardwareMap);
        camera = new Camera(hardwareMap);
    }
}
