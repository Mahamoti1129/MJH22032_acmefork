package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Arm extends SubsystemBase {
    private final Servo wristServo;
    private final DcMotorEx armMotor;
    public static class ArmPidControllerConstants {
        public double p, i, d, f;
    }
    public static ArmPidControllerConstants ARM_PID_PARAMS = new ArmPidControllerConstants();

    private final PIDFController armPidController;

    public final int armBottom;
    public final int armTop;

    public Arm(HardwareMap hardwareMap){
        wristServo = hardwareMap.get(Servo.class, "wristServo");
        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");

        armBottom = armMotor.getCurrentPosition();
        armTop = armBottom + 100;

        armPidController = new PIDFController(
                ARM_PID_PARAMS.p, ARM_PID_PARAMS.i,
                ARM_PID_PARAMS.d, ARM_PID_PARAMS.f
            );
    }

    public void moveArm(double input){
        int armPos = armMotor.getCurrentPosition();
        double currentPos = armMotor.getCurrentPosition() - armBottom;
        double target;

        if (input > 0){
            target = currentPos + ((armTop - currentPos) * input);
        }else if (input < 0) {
            target = currentPos - ((currentPos - armBottom) * input);
        }else return;

        armPidController.setPIDF(ARM_PID_PARAMS.p, ARM_PID_PARAMS.i, ARM_PID_PARAMS.d, ARM_PID_PARAMS.f);
        double pid = armPidController.calculate(armPos, target);

        armMotor.setPower(pid);
    }
}
