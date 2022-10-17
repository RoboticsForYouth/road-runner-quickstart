package org.firstinspires.ftc.teamcode.freightFrenzy.tools;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;

@Autonomous(name = "IntakeAuto")
public class Intake extends LinearOpMode {

    CRServo intake;
    LinearOpMode opMode;

    private static final double INTAKE_POWER = -1.0;
    private static final double DROP_POWER = 1.0;

    public void setup() {
        intake = opMode.hardwareMap.get(CRServo.class, "intake");
    }

    public Intake() { opMode = this; }

    public Intake(LinearOpMode opMode) {
        this.opMode = opMode;
        setup();
    }

    public void intake() { intake.setPower(INTAKE_POWER);
    }

    public void reverseIntake() {
        intake.setPower(DROP_POWER);
    }

    public void drop() {
        reverseIntake();
        sleep(2000);
        stopIntake();

    }

    public void dropInstant() {
        reverseIntake();
        while( intake.getPower() == 0){
            opMode.sleep(100);
        }
    }


    public void stopIntake() {
        intake.setPower(0);
    }

    public void timeIntake(int ms) {
        intake();
        sleep(ms);
        stopIntake();
    }

    @Override
    public void runOpMode() {
        setup();

        waitForStart();

        intake();
        sleep(4000);
        drop();
        sleep(2000);
        stopIntake();
    }


}