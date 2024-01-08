package org.firstinspires.ftc.teamcode;


import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous
public class AutonBlueCenter extends LinearOpMode {


    @Override


    public void runOpMode() throws InterruptedException
    {
        Pose2d startPose = new Pose2d(0, 0, 0);
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);

        // Declare Control Hub Orientation
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.DOWN;


        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);


        // Declare Motors
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "backRight");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "backLeft");


        rightFront.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);


        DcMotor viper = hardwareMap.get(DcMotor.class, "viper");


        // Declare Servos
        Servo claw = hardwareMap.get(Servo.class, "claw");
        Servo arm = hardwareMap.get(Servo.class, "arm");


        // Declare IMU
        IMU imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(orientationOnRobot));




        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        viper.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();


        if (isStopRequested()) return;


        while (opModeIsActive())
        {
            TrajectoryActionBuilder BlueCenter = drive.actionBuilder(new Pose2d(12.24, 67.89, Math.toRadians(268.22)))
                    .splineTo(new Vector2d(11.66, 48.49), Math.toRadians(268.65))
                    .splineTo(new Vector2d(11.27, 31.84), Math.toRadians(270.00))
                    .splineTo(new Vector2d(51.23, 34.19), Math.toRadians(0.00))
                    .build();






        }






    }




}
