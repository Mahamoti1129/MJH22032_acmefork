package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {

    private DcMotorEx pivotMotor;
    private DcMotorEx liftMotor;

    private ServoEx clawServo;

    private Telemetry telemetry;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry){
        this.pivotMotor = hardwareMap.get(DcMotorEx.class, "pivotMotor");
        this.liftMotor = hardwareMap.get(DcMotorEx.class, "liftMotor");
        this.clawServo = hardwareMap.get(ServoEx.class, "clawServo");
        this.telemetry = telemetry;
    }

    public void openClaw(){
        clawServo.setPosition(0d);
    }

    public void closeClaw(){
        clawServo.setPosition(180d);
    }

    public void pivotArm(double velocity){
        pivotMotor.setPower(velocity);
    }

    public void lift(double velocity){
        liftMotor.setPower(velocity);
    }
}
