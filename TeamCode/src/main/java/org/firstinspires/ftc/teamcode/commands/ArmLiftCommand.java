package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystem.Arm;

public class ArmLiftCommand extends CommandBase {

    private final Arm arm;
    private final GamepadEx widgetController;

    public ArmLiftCommand(Arm arm, GamepadEx widgetController) {
        this.arm = arm;
        this.widgetController = widgetController;
    }


    @Override
    public void execute() {
        arm.lift(-widgetController.getLeftY());
    }

}
