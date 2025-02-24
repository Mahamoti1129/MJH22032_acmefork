package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.roadrunner.ftc.OverflowEncoder;
import com.acmerobotics.roadrunner.ftc.RawEncoder;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {

    private final DcMotorEx pivotMotor;
    private final DcMotorEx liftMotor;
    private final OverflowEncoder liftEncoder;
    private final int LIFT_ENCODER_MIN = 0;
    private final int LIFT_ENCODER_MAX = 9999;

    private final Servo leftClaw;
    private final Servo rightClaw;

    private final Telemetry telemetry;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry){
        this.pivotMotor = hardwareMap.get(DcMotorEx.class, "armlift");
        this.pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.liftMotor = hardwareMap.get(DcMotorEx.class, "armextension");
        this.liftEncoder =  new OverflowEncoder(new RawEncoder(hardwareMap.get(DcMotorEx.class, "armextension")));
        this.liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        this.leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        this.rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        super.periodic();

        this.telemetry.addData("Arm Extension Encoder: ", this.liftEncoder.getPositionAndVelocity().position);
        this.telemetry.update();
    }

    public void openClaw(){
        leftClaw.setPosition(0.4);
        rightClaw.setPosition(0.6);
        telemetry.addLine("claw open");
        telemetry.update();
    }

    public void closeClaw(){
        leftClaw.setPosition(0.55);
        rightClaw.setPosition(0.45);
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

        int position = liftEncoder.getPositionAndVelocity().position;

        if (velocity >0 && position > LIFT_ENCODER_MAX){
            liftMotor.setPower(0);
            return;
        }

        if (velocity <0 && position < LIFT_ENCODER_MIN){
            liftMotor.setPower(0);
            return;
        }

        liftMotor.setPower(velocity);
    }
}
