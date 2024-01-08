package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class AutonomousR extends LinearOpMode {

    public void openArm(Servo arm) {
        arm.setPosition(1);
    }

    @Override

    public void runOpMode() throws InterruptedException {
        int startx = 1;
        int starty = 1;
        double heading = 90;

        //Servo arm = hardwareMap.
        // HardwareMap hardwareMap = new HardwareMap();
        MecanumDrive g = new MecanumDrive(hardwareMap, new Pose2d(startx, starty, heading));

        g.actionBuilder(new Pose2d(startx, starty, heading))
                .lineToX(30)
                .turn(40)
                //openArm()
                .build();


    }
}

