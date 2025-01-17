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

    private final Servo clawServo;

    private final Telemetry telemetry;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry){
        this.pivotMotor = hardwareMap.get(DcMotorEx.class, "armlift");
        this.liftMotor = hardwareMap.get(DcMotorEx.class, "armextension");
        this.clawServo = hardwareMap.get(Servo.class, "claw");
        this.telemetry = telemetry;
    }

    public void openClaw(){
        telemetry.addLine("open claw");
        telemetry.update();
        clawServo.setPosition(0d);
    }

    public void closeClaw(){
        telemetry.addLine("close claw");
        telemetry.update();
        clawServo.setPosition(1.0d);
    }

    public void pivotArm(double velocity){
        telemetry.addData("Pivot arm: ", velocity);
        telemetry.update();
        pivotMotor.setPower(velocity/2);
    }

    public void lift(double velocity){
        telemetry.addData("Lift value: ", velocity);
        telemetry.update();
        liftMotor.setPower(velocity);
    }
}
