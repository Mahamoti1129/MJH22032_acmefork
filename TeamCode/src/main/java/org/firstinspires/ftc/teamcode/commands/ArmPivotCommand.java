package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystem.Arm;

public class ArmPivotCommand extends CommandBase {

    private final Arm arm;
    private final GamepadEx widgetController;

    public ArmPivotCommand(Arm arm, GamepadEx widgetController) {
        this.arm = arm;
        this.widgetController = widgetController;
    }


    @Override
    public void execute() {
        arm.pivotArm(-widgetController.getRightY());
    }
}
