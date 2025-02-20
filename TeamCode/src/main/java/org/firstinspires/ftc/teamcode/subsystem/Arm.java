package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {

    private final DcMotorEx pivotMotor;
    private final DcMotorEx liftMotor;

    private final Servo leftClaw;
    private final Servo rightClaw;

    private final Telemetry telemetry;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry){
        this.pivotMotor = hardwareMap.get(DcMotorEx.class, "armlift");
        this.liftMotor = hardwareMap.get(DcMotorEx.class, "armextension");
        this.leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        this.rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        this.telemetry = telemetry;
    }

    public void openClaw(){
        leftClaw.setPosition(0.0);
        rightClaw.setPosition(0.8);
        telemetry.addLine("claw open");
        telemetry.update();
    }

    public void closeClaw(){
        leftClaw.setPosition(0.5);
        rightClaw.setPosition(0.5);
        telemetry.addLine("claw closed");
        telemetry.update();
    }


    public void pivotArm(double velocity){
        telemetry.addData("Pivot arm: ", velocity);
        telemetry.update();
        pivotMotor.setPower(velocity);
    }

    public void lift(double velocity){
        telemetry.addData("Lift value: ", velocity);
        telemetry.update();
        liftMotor.setPower(velocity);
    }
}
