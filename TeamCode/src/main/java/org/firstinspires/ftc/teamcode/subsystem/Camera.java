package org.firstinspires.ftc.teamcode.subsystem;

import android.content.Intent;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

public class Camera {
    Intent intent = new Intent ("android.media.action.IMAGE_CAPTURE"); startActivity (intent);
    TfodProcessor tfodProcesser = TfodProcessor.easyCreateWithDefaults();
    VisionPortal visionPortal = VisionPortal.easyCreateWithDefaults(Camera, TfodProcessor);
    List<Recognition> recognitions = tfodProcesser .getRecognitions();
    for (Recognition recognition : recognitions)
}

String label = recognition.getLabel();

float confidence = recognition.getConfidence();

telemetry.addline("Recognized object: " + label);
telemetry.addline("Confidence: " + confidence);
