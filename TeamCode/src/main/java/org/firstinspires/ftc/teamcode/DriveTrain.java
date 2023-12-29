// import statements
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class DriveTrain extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException
    {
        // Declare Control Hub Orientation
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.DOWN;

        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        // Declare Motors
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "backRight");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "backLeft");

        DcMotor viper = hardwareMap.get(DcMotor.class, "viper");

        // Declare Servos
        Servo claw = hardwareMap.get(Servo.class, "claw");
        Servo arm = hardwareMap.get(Servo.class, "arm");

        // Declare IMU
        IMU imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(orientationOnRobot));



        double frontRightPower;
        double frontLeftPower;
        double backRightPower;
        double backLeftPower;

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        viper.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while(opModeIsActive())
        {
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double denominator = Math.max(Math.abs(drive) + Math.abs(strafe) + Math.abs(turn), 1);

            double pi = Math.PI;


            double gyro_degrees = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
            double gyro_radians = gyro_degrees * pi/180;
            double temp = drive * java.lang.Math.cos(gyro_radians) + strafe * java.lang.Math.sin(gyro_radians);
            strafe = -drive * java.lang.Math.sin(gyro_radians) + strafe * java.lang.Math.cos(gyro_radians);
            drive = temp;


            frontLeftPower = (drive + strafe + turn) / denominator;
            frontRightPower = (drive - strafe - turn) / denominator;
            backLeftPower = (drive - strafe + turn) / denominator;
            backRightPower = (drive + strafe - turn) / denominator;

            // Wheels
            leftFront.setPower(frontLeftPower);
            rightFront.setPower(frontRightPower);
            leftBack.setPower(backLeftPower);
            rightBack.setPower(backRightPower);

            // claw
            if (gamepad1.a) {claw.setPosition(0);}
            else {claw.setPosition(1);}

            //arm

            if (gamepad1.y) arm.setPosition(1);

            if (gamepad1.b)
            {
                viper.setPower(-1);
                arm.setPosition(0);
            }

            //viper slide
            if (gamepad1.dpad_up) viper.setPower(1);
            if (gamepad1.dpad_down) viper.setPower(-1);







        }



    }


}