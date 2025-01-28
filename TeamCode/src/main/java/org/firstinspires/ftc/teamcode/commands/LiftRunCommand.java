package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystem.Arm;
import org.firstinspires.ftc.teamcode.subsystem.Lift;

public class LiftRunCommand extends CommandBase {

    private final Lift lift;
    private final GamepadEx widgetController;

    public LiftRunCommand(Lift lift, GamepadEx widgetController) {
        this.lift = lift;
        this.widgetController = widgetController;
    }

    @Override
    public void execute() {
        double left = widgetController.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER),
                right = widgetController.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);

        if (widgetController.isDown(GamepadKeys.Button.X)) {
            left = -left;
            right = -right;
        }
        lift.lift(left, right);
    }

}
