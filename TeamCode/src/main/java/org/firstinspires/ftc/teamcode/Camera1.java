package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import java.util.*;

@TeleOp
public class Camera1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        AprilTagProcessor camera = AprilTagProcessor.easyCreateWithDefaults();
        VisionPortal eyes = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Camera"), camera);


      //  List<AprilTagDetection> aprilTags = new ArrayList<AprilTagDetection>();
     //    AprilTagDetection found;


        for (AprilTagDetection a : camera.getDetections())
        {
            if (a.id == 1)
            {
                // function
            }
            //if (a.i)
        }

    }
}
