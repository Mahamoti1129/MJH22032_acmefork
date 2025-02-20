package org.firstinspires.ftc.teamcode.commands;

import static com.arcrobotics.ftclib.util.MathUtils.clamp;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystem.Arm;

public class ArmPivotCommand extends CommandBase {

    private final Arm arm;
    private final GamepadEx widgetController;

    private final double ARMSPEED = 0.8;

    public ArmPivotCommand(Arm arm, GamepadEx widgetController) {
        this.arm = arm;
        this.widgetController = widgetController;
    }


    @Override
    public void execute() {

        arm.pivotArm(
                clamp(
                        Math.pow(-widgetController.getRightY(), 3),
                        -ARMSPEED,
                        ARMSPEED
                )
        );
    }
}
