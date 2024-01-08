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
        MechanumDrive g = new MecanumDrive(hardwareMap, new Pose2d());
        //TrajectoryActionBuilder g = new TrajectoryActionBuilder()
        
        Trajectory trajectory = g.TrajectoryActionBuilder(new Pose2d())
            .forward(30)
            .build();
        
        g.FollowTrajectoryAction(trajectory);

        
        

        path j = new path();
        j.gotoMiddle();


    }
}

