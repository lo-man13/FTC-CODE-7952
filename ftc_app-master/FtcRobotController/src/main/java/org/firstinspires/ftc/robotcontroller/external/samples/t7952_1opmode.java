/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Template: Linear OpMode", group="Linear Opmode")  // @Autonomous(...) is the other common choice
public class PushbotTeleopTank_Iterative extends OpMode {

    /* Declare OpMode members. */
    //Declare all DC Motors here//
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftMotorFront;
    DcMotor rightMotorFront;
    DcMotor leftMotorRear;
    DcMotor rightMotorRear;
    DcMotor flipperMotor1;
    DcMotor radMotor1;
    DcMotor radMotor2;
    Servo dumb;
    double leftMotorRearPower = 0;
    double RightMotorRearPower = 0;
    double leftMotorFrontPower = 0;
    double RightMotorFrontPower = 0;
    double flipperMotor1 = 0;
    double flipperMotor2 = 0;
    double dumb = 0;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
       final static String leftMotorFront  = hardwareMap.dcMotor.get("left motor front");
       final static String rightMotorFront = hardwareMap.dcMotor.get("right motor front");
       final static String leftMotorRear = hardwareMap.dcMotor.get("left motor rear");
       final static String RightMotorRear = hardwareMap.dcMotor.get("right motor rear");
       final static String flipperMotor1 = hardwareMap.dcMotor.get("belt motor1");
       final static String flipperMotor2 = hardwareMap.dcMotor.get("belt motor2");

        // "Reverse" the motor that runs backwards when connected directly to the battery
        leftMotorFront.setDirection(DcMotor.Direction.FORWARD);
        rightMotorFront.setDirection(DcMotor.Direction.REVERSE);
        leftMotorRear.setDirection(DcMotor.Direction.FORWARD);
        rightMotorRear.setDirection(DcMotor.Direction.REVERSE);
        flipperMotor1.setDirection(DcMotor.Direction.FORWARD);
        flipperMotor2.setDirection(DcMotor.Direction.FORWARD);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            //Set the power of each motor to be controlled by each control stick corrosponding to the side of the motor//
            leftMotorFront.setPower(-gamepad1.left_stick_y);
            rightMotorFront.setPower(-gamepad1.right_stick_y);
            leftMotorRear.setPower(-gamepad1.left_stick_y);
            rightMotorRear.setPower (-gamepad1.right_stick_y);
            flipperMotor1.setPower (-gamepad2.right_trigger);
            flipperMotor2.setPower (-gamepad2.right_trigger);

            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}
