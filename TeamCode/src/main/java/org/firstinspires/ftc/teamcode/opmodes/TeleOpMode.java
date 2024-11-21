package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.TheRobot;
import org.firstinspires.ftc.teamcode.commands.JoystickDriveCommand;

import java.util.Set;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOpMode extends CommandOpMode {
    private TheRobot robot;

    @Override
    public void initialize() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);

        telemetry.addData("Robot Status", "Initializing TeleOp OpMode");
    }
}
