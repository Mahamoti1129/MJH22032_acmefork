package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

public class ShortParkOnlyCommand extends CommandBase {

    private DriveTrain driveTrain;

    public ShortParkOnlyCommand(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
    }

    @Override
    public void execute() {
        driveTrain.actionBuilder(new Pose2d(24, -62, Math.PI/2))
                .splineTo(new Vector2d(72, -66), 0)
                .build();
    }
}
