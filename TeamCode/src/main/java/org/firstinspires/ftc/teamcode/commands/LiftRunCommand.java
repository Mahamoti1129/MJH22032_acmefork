package org.firstinspires.ftc.teamcode.commands;

import static com.arcrobotics.ftclib.util.MathUtils.clamp;

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
        double left = clamp(
                        Math.pow(widgetController.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER), 3),
                        -0.8,
                        0.8),
                right = clamp(
                        Math.pow(widgetController.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER), 3),
                        -0.8,
                        0.8);

        if (widgetController.isDown(GamepadKeys.Button.X)) {
            left = -left;
            right = -right;
        }
        lift.lift(left, right);
    }

}
