package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;

public class PushSampleCommand extends CommandBase {

    private Drivetrain driveTrain;

    public PushSampleCommand(Drivetrain driveTrain) {
        this.driveTrain = driveTrain;
    }

    @Override
    public void execute() {
        driveTrain.actionBuilder(new Pose2d(-24, -62, Math.PI))
                .lineToX(-60)
                .build();
    }
}
