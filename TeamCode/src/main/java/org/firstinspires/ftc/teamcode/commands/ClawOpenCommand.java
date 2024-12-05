package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystem.Arm;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

public class ClawOpenCommand extends CommandBase {

    private final Arm arm;

    public ClawOpenCommand(Arm arm) {
        this.arm = arm;
    }

    @Override
    public void execute() {
        arm.openClaw();
    }
}
