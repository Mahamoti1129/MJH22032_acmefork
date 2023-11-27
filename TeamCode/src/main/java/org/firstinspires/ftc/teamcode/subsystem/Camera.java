package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.Optional;

public class Camera {
    private final TfodProcessor tfodProcessor = TfodProcessor.easyCreateWithDefaults();
    private final AprilTagProcessor aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
    private final VisionPortal visionPortal;
    public Camera(HardwareMap hardwareMap){
        WebcamName camera = hardwareMap.get(WebcamName.class, "Webcam 1");
        visionPortal = VisionPortal.easyCreateWithDefaults(
                camera,
                tfodProcessor,
                aprilTagProcessor
            );
    }

    public Optional<AprilTagPoseFtc> findAprilTag(int aprilTagId){
        for (AprilTagDetection detection: aprilTagProcessor.getDetections()){
            if (detection.id == aprilTagId){
                return Optional.of(detection.ftcPose);
            }
        }
        return Optional.empty();
    }

    public Optional<Recognition> findTokenPosition(){
        /* TODO: get token position using tfodProcessor
        for (Recognition recognition: tfodProcessor.getRecognitions()){
            if(recognition.getConfidence() > PARAMS.getMinimumConfidence()){
                double degrees = recognition.estimateAngleToObject(AngleUnit.DEGREES);

                if (degrees < -PARAMS.getCenterWidth()/2){
                    return Optional.of(TokenPosition.LEFT);
                }else if (degrees > PARAMS.getCenterWidth()/2){
                    return Optional.of(TokenPosition.RIGHT);
                }else {
                    return Optional.of(TokenPosition.CENTER);
                }
            }
        }
        */
        return Optional.empty();
    }
}
