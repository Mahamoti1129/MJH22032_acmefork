package org.firstinspires.ftc.teamcode.opmode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
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

        schedule(new JoystickDriveCommand(robot.drivetrain, robot.driveController));

        new GamepadButton(robot.driveController, GamepadKeys.Button.A).toggleWhenPressed(
                new InstantCommand(() -> {
                    robot.arm.openClaw();
                }), new InstantCommand(() -> {
                    robot.arm.closeClaw();
                })
            );
    }
}
