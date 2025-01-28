package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TheRobot;
import org.firstinspires.ftc.teamcode.commands.ArmLiftCommand;
import org.firstinspires.ftc.teamcode.commands.ArmPivotCommand;
import org.firstinspires.ftc.teamcode.commands.ClawCloseCommand;
import org.firstinspires.ftc.teamcode.commands.ClawOpenCommand;
import org.firstinspires.ftc.teamcode.commands.JoystickDriveCommand;
import org.firstinspires.ftc.teamcode.commands.LiftRunCommand;

import java.util.Set;

@TeleOp(name="TeleOp", group="TeleOp")
public class TeleOpMode extends CommandOpMode {
    private TheRobot robot;

    @Override
    public void initialize() {
        robot = new TheRobot(hardwareMap, gamepad1, gamepad2, telemetry);

        telemetry.addData("Robot Status", "Initializing TeleOp OpMode");

        schedule(new JoystickDriveCommand(robot.drivetrain, robot.driveController));

//        new GamepadButton(robot.widgetController, GamepadKeys.Button.A).toggleWhenPressed(
//                new InstantCommand(() -> robot.arm.openClaw()),
//                new InstantCommand(() -> robot.arm.closeClaw())
//            );
//        schedule(new ClawOpenCommand(robot.arm, robot.widgetController, telemetry));

        new GamepadButton(robot.widgetController, GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new ClawOpenCommand(robot.arm, robot.widgetController, telemetry),
                new ClawCloseCommand(robot.arm, robot.widgetController, telemetry)
        );

        schedule(new ArmLiftCommand(robot.arm, robot.widgetController));
        schedule(new ArmPivotCommand(robot.arm, robot.widgetController));

        schedule(new LiftRunCommand(robot.lift, robot.widgetController));

        telemetry.addLine("Telemetry initialized.");
        telemetry.update();
    }


}
