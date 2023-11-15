package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public final MecanumDrive drive;
    public final DroneLauncher droneLauncher;
    public final Camera camera;

    public Robot(HardwareMap hardwareMap, Pose2d pose){
        drive = new MecanumDrive(hardwareMap, pose);
        droneLauncher = new DroneLauncher(hardwareMap);
        camera = new Camera(hardwareMap);
    }
}
