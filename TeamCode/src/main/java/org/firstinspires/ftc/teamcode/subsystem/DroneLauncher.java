package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DroneLauncher {

    private final Servo servo;

    public DroneLauncher (HardwareMap hardwareMap){
        servo = hardwareMap.get(Servo.class, "droneLauncher");
        servo.setPosition(0);
        //where servo starts, needs to be the prepped to launch position
    }
    public void launch(){
        //Todo: move the servo to launch the drone
        servo.setPosition(90);
        // position after the drone is launched
        //ToDo: add in values for where the servo needs to be
    }
}
