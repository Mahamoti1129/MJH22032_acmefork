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
    public enum Alliance {
        RED, BLUE;
    }
    public enum TokenPosition {
        LEFT, CENTER, RIGHT;

        public int getAprilTagId(Alliance alliance){
            switch (alliance){
                case RED: switch(this) {
                    case LEFT: return 1;
                    case CENTER: return 2;
                    case RIGHT: return 3;
                }
                case BLUE: switch(this){
                    case LEFT: return 4;
                    case CENTER: return 5;
                    case RIGHT: return 6;
                }
            }

            return 0;
        }
    }

    @Config
    public static final class PARAMS {
        private static final double centerWidth = 20.0;
        private static final float minimumConfidence = 0.80f;

        public static double getCenterWidth(){
            return centerWidth;
        }

        public static float getMinimumConfidence(){
            return minimumConfidence;
        }
    }
    private final TfodProcessor tfodProcessor = TfodProcessor.easyCreateWithDefaults();
    private final AprilTagProcessor aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
    private final VisionPortal visionPortal;
    public Camera(HardwareMap hardwareMap){
        WebcamName camera = hardwareMap.get(WebcamName.class, "Camera 1");
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

    public Optional<TokenPosition> findTokenPosition(){
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
        return Optional.empty();
    }
}
