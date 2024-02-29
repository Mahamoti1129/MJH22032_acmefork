package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {
    private final DcMotorEx motor;

    public Lift(HardwareMap hardwareMap){
        motor = hardwareMap.get(DcMotorEx.class, "liftMotor");
    }

    public void move(double power){
        motor.setPower(power);
    }
}
