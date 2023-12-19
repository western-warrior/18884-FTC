// import statements
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class DriveTrain extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException
    {
        // Declare Motors
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "backRight");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "backLeft");

        DcMotor viper = hardwareMap.get(DcMotor.class, "viper");

        // Declare Servos
        Servo claw = hardwareMap.get(Servo.class, "claw");
        Servo arm = hardwareMap.get(Servo.class, "arm");


        double frontRightPower = 0;
        double frontLeftPower = 0;
        double backRightPower = 0;
        double backLeftPower = 0;

        double viperPosition = viper.getCurrentPosition();

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
                //arm.setPosition(0);
//                for (int i = 0; i > -1; i ++)
//                {
//                    if (viper.getCurrentPosition() < viperPosition)
//                    {
//                        viper.setPower(-1);
//                    }
//                    if (viper.getCurrentPosition() == viperPosition || viper.getCurrentPosition() > viperPosition)
//                    {
//                        break;
//                    }
//                }
                viper.setPower(-1);
                arm.setPosition(0);
            }
          //  while (viper.getCurrentPosition() != viperPosition)
            //    viper.setPower(-1);

            //viper slide
            if (gamepad1.dpad_up) viper.setPower(1);
            if (gamepad1.dpad_down) viper.setPower(-1);







        }



    }


}