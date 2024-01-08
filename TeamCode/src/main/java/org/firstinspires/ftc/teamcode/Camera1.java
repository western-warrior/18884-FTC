package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import java.util.*;

@Autonomous
public class Camera1 extends LinearOpMode {

    int startx = 1;
    int starty = 1;
    double heading = 90;
    public void left(MecanumDrive g) {

        g.actionBuilder(new Pose2d(startx, starty, heading))
                .lineToX(40)
                .turn(40)
                //openArm()
                .build();

    }
    @Override
    public void runOpMode() throws InterruptedException {

        //int startx = 1;
        //int starty = 1;
        //double heading = 90;

        //Servo arm = hardwareMap.
        // HardwareMap hardwareMap = new HardwareMap();
        MecanumDrive g = new MecanumDrive(hardwareMap, new Pose2d(startx, starty, heading));

        left(g);

        AprilTagProcessor camera = AprilTagProcessor.easyCreateWithDefaults();
        VisionPortal eyes = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Camera"), camera);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            //  List<AprilTagDetection> aprilTags = new ArrayList<AprilTagDetection>();
            //    AprilTagDetection found;


            for (AprilTagDetection a : camera.getDetections()) {
                if (a.id == 1) {

                  //  MecanumDrive.FollowTrajectoryAction follow = new MecanumDrive.FollowTrajectoryAction(

                }
                //if (a.i)
            }
        }

    }
}
