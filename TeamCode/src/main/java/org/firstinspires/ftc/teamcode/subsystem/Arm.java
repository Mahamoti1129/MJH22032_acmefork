package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Arm extends SubsystemBase {
    private final Servo wristServo;
    private final DcMotorEx armMotor;
    public static class ArmPidControllerConstants {
        public double p = 0.008,
                i = 0.005,
                d = 0.0001,
                f = 0.001;
    }
    public static ArmPidControllerConstants ARM_PID_PARAMS = new ArmPidControllerConstants();

    private final PIDFController armPidController;

    public static double target;
    public static int armBottom = 20;
    public static int armTop = 225;
    public static int verticalPos = 250;

    public static double wristMoveStep = 0.025;

    public Arm(HardwareMap hardwareMap){
        wristServo = hardwareMap.get(Servo.class, "wristServo");
        wristServo.setPosition(0.0);

        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");
        target = 0;
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armPidController = new PIDFController(
                ARM_PID_PARAMS.p, ARM_PID_PARAMS.i,
                ARM_PID_PARAMS.d, ARM_PID_PARAMS.f
            );
    }

    public void setTargetUp(double input){
        target += ((armTop - target) * Math.pow(input/4, 2));
    }
    public void setTargetDown(double input){
        target -= ((target - armBottom) * Math.pow(input/4, 2));
    }
    public void moveArm(){
        int armPos = armMotor.getCurrentPosition();
        armPidController.setPIDF(ARM_PID_PARAMS.p, ARM_PID_PARAMS.i, ARM_PID_PARAMS.d, ARM_PID_PARAMS.f);
        double pid = armPidController.calculate(armPos, target);
        armMotor.setPower(pid);

        Telemetry telemetry = FtcDashboard.getInstance().getTelemetry();
        telemetry.addData("arm pid", pid);
        telemetry.addData("arm currentPos", armPos);
        telemetry.addData("arm target", target);

        telemetry.addData("wristServoPos", wristServo.getPosition());

        telemetry.update();
    }

    public int getCurrentPosition() {
        return armMotor.getCurrentPosition();
    }
    public double getCurrentWristPosition() {
        return wristServo.getPosition();
    }

    public void moveWristDown(){
        wristServo.setPosition(wristServo.getPosition()+wristMoveStep);
    }
    public void moveWristUp(){
//        wristServo.setPosition(Math.max(wristServo.getPosition()-wristMoveStep, 0.3));
        wristServo.setPosition(wristServo.getPosition()-wristMoveStep);
    }

    public void killArmMotor(){
        armMotor.setMotorDisable();
    }

    public void setEncoderEndpoint(){
        armMotor.setMotorDisable();
        armMotor.setTargetPosition(0);
        armMotor.setMotorEnable();
        target = 0;
    }
}
