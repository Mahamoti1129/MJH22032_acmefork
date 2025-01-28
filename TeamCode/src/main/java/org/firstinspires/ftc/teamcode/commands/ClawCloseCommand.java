package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystem.Arm;

public class ClawCloseCommand extends CommandBase {

    private final Arm arm;
    private final Telemetry telemetry;
    public ClawCloseCommand(Arm arm, GamepadEx widgetController, Telemetry telemetry) {
        this.arm = arm;
        this.telemetry = telemetry;
    }

    @Override
    public void execute() {
        telemetry.addLine("close claw");
        telemetry.update();
        arm.closeClaw();
    }
}
