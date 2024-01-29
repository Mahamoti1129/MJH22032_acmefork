package org.firstinspires.ftc.teamcode.subsystem;

import android.widget.Button;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptGamepadTouchpad;

public class DroneLauncher {
    private final Servo servo;

    public DroneLauncher(HardwareMap hardwareMap){
        servo = hardwareMap.get(Servo.class, "droneLauncher");
        servo.setPosition(90);
    }

    public void launch(){
        servo.setPosition(180);
    }
}
