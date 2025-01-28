package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystem.Arm;
import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;

public class ClawOpenCommand extends CommandBase {

    private final Arm arm;
    private final Telemetry telemetry;
    public ClawOpenCommand(Arm arm, GamepadEx widgetController, Telemetry telemetry) {
        this.arm = arm;
//        this.widgetController = widgetController;
        this.telemetry = telemetry;
    }

    @Override
    public void execute() {
        telemetry.addLine("open claw");
        telemetry.update();
        arm.openClaw();
    }
}
