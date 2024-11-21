package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MecanumDrive;

public class DriveTrain extends SubsystemBase {
    private MecanumDrive mecanumDrive;
    private GamepadEx driveController;
    private Telemetry telemetry;
     public DriveTrain(HardwareMap hardwaremap, Telemetry telemetry, GamepadEx controller1) {
         telemetry.addLine("Initializing drivetrain...");

         this.telemetry = telemetry;
         this.driveController = controller1;

         this.mecanumDrive = new MecanumDrive(hardwaremap, new Pose2d(0.0d, 0.0d, 0.0d));

         telemetry.addLine("Drivetrain initialized.");
     }

    public void setDrivePowers(PoseVelocity2d pose){
        mecanumDrive.setDrivePowers(pose);
    }

    public void stopDrive() {
        mecanumDrive.stop();
    }
}
