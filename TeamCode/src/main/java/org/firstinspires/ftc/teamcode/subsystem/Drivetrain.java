package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MecanumDrive;

public class Drivetrain extends SubsystemBase {
    private final MecanumDrive mecanumDrive;
    private final Telemetry telemetry;
     public Drivetrain(HardwareMap hardwaremap, Telemetry telemetry) {
         telemetry.addLine("Initializing drivetrain...");

         this.telemetry = telemetry;

         this.mecanumDrive = new MecanumDrive(hardwaremap, new Pose2d(0.0d, 0.0d, 0.0d));

         telemetry.addLine("Drivetrain initialized.");
     }

    public void setDrivePowers(PoseVelocity2d pose){
        mecanumDrive.setDrivePowers(pose);
        telemetry.addData("Drive powers: ", pose);
        telemetry.update();
    }

    public void stopDrive() {
        mecanumDrive.stop();
    }

    public TrajectoryActionBuilder actionBuilder(Pose2d beginPose) {
        return mecanumDrive.actionBuilder(beginPose);
    }
}
