package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DroneLauncher {
    private final Servo servo;

    public DroneLauncher(HardwareMap hardwareMap){
        servo = hardwareMap.get(Servo.class, "droneLauncher");
        servo.setPosition(0);
    }

    public void launch(){
        //TODO: move the servo to launch the drone
        servo.setPosition(90);
    }
}
