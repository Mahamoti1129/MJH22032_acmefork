package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {

    private  DcMotorEx pivotMotor;
    private  DcMotorEx liftMotor;

    private  ServoEx clawServo;

    private final Telemetry telemetry;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry){
//        this.pivotMotor = hardwareMap.get(DcMotorEx.class, "pivotMotor");
//        this.liftMotor = hardwareMap.get(DcMotorEx.class, "liftMotor");
//        this.clawServo = hardwareMap.get(ServoEx.class, "clawServo");
        this.telemetry = telemetry;
    }

    public void openClaw(){
        telemetry.addLine("open claw");
        telemetry.update();
        //clawServo.setPosition(0d);
    }

    public void closeClaw(){
        telemetry.addLine("close claw");
        telemetry.update();
        //clawServo.setPosition(180d);
    }

    public void pivotArm(double velocity){
        telemetry.addData("Pivot arm: ", velocity);
        telemetry.update();
        // pivotMotor.setPower(velocity);
    }

    public void lift(double velocity){
        telemetry.addData("Lift value: ", velocity);
        telemetry.update();
        //liftMotor.setPower(velocity);
    }
}
