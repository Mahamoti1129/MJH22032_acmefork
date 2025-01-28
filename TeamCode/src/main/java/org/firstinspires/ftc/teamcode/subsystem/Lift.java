package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift extends SubsystemBase {

    private final DcMotorEx leftMotor;
    private final DcMotorEx rightMotor;


    private final Telemetry telemetry;

    public Lift(HardwareMap hardwareMap, Telemetry telemetry){
        this.leftMotor = hardwareMap.get(DcMotorEx.class, "leftclimb");
        this.rightMotor = hardwareMap.get(DcMotorEx.class, "rightclimb");
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.telemetry = telemetry;
    }

    public void lift(double leftvelocity, double rightvelocity){
        leftMotor.setPower(leftvelocity);
        rightMotor.setPower(rightvelocity);
    }
}
