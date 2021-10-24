package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.ftc.waterloo.h2oloobots.AttachmentControl;
import org.ftc.waterloo.h2oloobots.DriveTrain;
import org.ftc.waterloo.h2oloobots.TelemetryControl;

@TeleOp
@Config
public class Tele1 extends LinearOpMode {

    public DriveTrain driveTrain = new DriveTrain();
    public AttachmentControl attachmentControl = new AttachmentControl();
    public TelemetryControl telemetryControl = new TelemetryControl();

    int waitForTelemetry = 0;

    public void runOpMode() {

        driveTrain.FourMotorInit(false, hardwareMap);
        attachmentControl.attachmentInit(hardwareMap, telemetry, 1);

        waitForStart();

        while (opModeIsActive()) {

            driveTrain.MecanumTeleOp(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, false, telemetry);
            attachmentControl.duckMotorTeleop(gamepad1.x);
            attachmentControl.liftMotorMove(gamepad1.y, gamepad1.a);

            telemetry.addData("Front Left Motor Power", driveTrain.fl.getPower());
            telemetry.addData("Front Right Motor Power", driveTrain.fr.getPower());
            telemetry.addData("Back Left Motor Power", driveTrain.bl.getPower());
            telemetry.addData("Back Right Motor Power", driveTrain.br.getPower());
            telemetry.addData("Lift Motor Position", attachmentControl.LiftMotor.getCurrentPosition());
            telemetry.addData("Duck Motor Power", attachmentControl.DuckMotor.getPower());
            telemetry.update();

        }

    }

}
