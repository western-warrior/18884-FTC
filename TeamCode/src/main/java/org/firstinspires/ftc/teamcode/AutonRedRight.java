// import statements
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class AutonRedRight extends LinearOpMode {

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


        }



    }


}