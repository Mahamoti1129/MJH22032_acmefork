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
        clawServo.setPosition(0.0);
        telemetry.addData("Arm.class open claw", clawServo.getPosition());
        telemetry.update();
    }

    public void closeClaw(){
        clawServo.setPosition(1.0);
        telemetry.addData("Arm.class close claw", clawServo.getPosition());
        telemetry.update();
    }

    public void clawPosition(double position){
        clawServo.setPosition(position);
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
