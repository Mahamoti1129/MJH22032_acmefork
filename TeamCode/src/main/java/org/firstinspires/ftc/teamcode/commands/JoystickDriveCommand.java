package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;

import java.util.Set;

public class JoystickDriveCommand extends CommandBase {

    private final Drivetrain driveTrain;
    private final GamepadEx driveController;

    public JoystickDriveCommand(Drivetrain driveTrain, GamepadEx driveController){
        this.driveTrain = driveTrain;
        this.driveController = driveController;
    }

    @Override
    public void execute() {
        driveTrain.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        driveController.getLeftY(),
                        driveController.getLeftX()
                ),
                driveController.getRightX()
        ));
    }
}
