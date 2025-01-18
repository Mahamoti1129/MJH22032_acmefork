package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

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
        lift.lift(widgetController.getLeftY());
    }

}
