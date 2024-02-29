package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.Optional;

public class Camera {
    private static final String TFOD_MODEL_ASSET = "red_and_blue_model.tflite";
    private static final String[] TFOD_LABELS = {
            "BlueProp",
            "RedProp"
        };

    private static final double CONFIDENCE = 0.9;

    private final TfodProcessor tfodProcessor = new TfodProcessor.Builder()
            .setModelAssetName(TFOD_MODEL_ASSET)
            .setModelLabels(TFOD_LABELS)
            .build();
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

    public Optional<Recognition> findTokenRecognition(){
        for (Recognition recognition: tfodProcessor.getRecognitions()){
            if(recognition.getConfidence() > CONFIDENCE){
                return Optional.of(recognition);
            }
        }

        return Optional.empty();
    }
}
