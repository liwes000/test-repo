package TeamCode.src.main.java.Main.TeleOp;

//import com.acmerobotics.dashboard.FtcDashboard;
//import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import Main.Base.HelperClasses.BooleanUpdater;
import Main.Base.HelperClasses.Button;
import Main.Base.HelperClasses.Button.*;
import Main.Base.Robot;
import Main.Base.RobotUtilities.WobbleArm;

import static Main.Base.HelperClasses.BooleanUpdater.*;
import static Main.Base.HelperClasses.Button.*;

//@Config
@TeleOp(name = "TeleOp", group = "competition")
public class RobotTeleOp extends Robot {

    boolean intakeLIn = false, intakeLOut = false, intakeRIn = false, intakeROut = false;

    boolean wobbleArmDown = false, wobbleClawClosed = false;

    boolean slomo = false, reverse = true;

    boolean FOD = true;

    boolean HIGH = false;

    //FtcDashboard dashboard;
    public static double highGoalVelocity = 1900;
    public static double powerShotVelocity = 800;
    public static double currentVelocity = 0;

    @Override
    public void init() {
        super.init();

        //dashboard = FtcDashboard.getInstance();
    }

    @Override
    public void loop() {

        buttonChecker = updateBooleans(gp, buttonChecker);
        currentVelocity = shooter.getVelocity();


        if (buttonChecker.get(x)) slomo = !slomo;

        if(buttonChecker.get(a)) reverse = !reverse;

        if(buttonChecker.get(left_stick_button)) FOD = !FOD;

        if(FOD) wheelBase.fieldOrientatedDrive(gp, gyro, slomo, reverse);
        else if(reverse) wheelBase.mecanumDrive(gp.left_stick_x, -gp.left_stick_y, gp.right_stick_x, slomo);
        else wheelBase.mecanumDrive(-gp.left_stick_y, -gp.left_stick_x, gp.right_stick_x, slomo);

        if(FOD) telemetry.addData("Drive: ", "FOD");
        else telemetry.addData("Drive: ", "ROD");



        intake.controlLIntake(intakeLIn, intakeLOut);
        intake.controlRIntake(intakeRIn, intakeROut);


//        if (buttonChecker.get(right_trigger)) {
//            intakeRIn = !intakeRIn;
//            intakeROut = false;
//        }

        if (buttonChecker.get(left_trigger)) {
            intakeLIn = !intakeLIn;
            intakeLOut = false;
        }

        if (buttonChecker.get(right_trigger)) {
            intakeLIn = !intakeLIn;
            intakeLOut = false;
        }

        if(gp.back) {
            intakeLOut = true;
            //intakeROut = true;
            intakeLIn = false;
            intakeRIn = false;
        }
        else {
            intakeLOut = false;
            intakeROut = false;
        }


        if (buttonChecker.get(right_bumper)) {
            intake.controlLIntake(false, false);
            intake.controlRIntake(false, false);
            intakeLIn = false;
            intakeRIn = false;
            shooter.shoot(true, 3);
        }

        if (buttonChecker.get(left_bumper)) {
            intake.controlLIntake(false, false);
            intake.controlRIntake(false, false);
            intakeLIn = false;
            intakeRIn = false;
            shooter.shoot(false, 1);
        }

//        if (buttonChecker.get(right_trigger)) HIGH = !HIGH;
//
//        if(HIGH) shooter.runFlyWheel(highGoalVelocity);
//        else shooter.stopFlyWheel();



        if(buttonChecker.get(b)) wobbleArmDown = !wobbleArmDown;

        wobbleArm.ControlWobbleArm(wobbleArmDown);


        if(buttonChecker.get(y)) wobbleClawClosed = !wobbleClawClosed;

        wobbleArm.ControlWobbleClaw(wobbleClawClosed);



        telemetry.addData("Heading: ", gyro.getHeading());

        if(buttonChecker.get(dpad_down)) shooter.changeHGV(10);

        if(buttonChecker.get(dpad_up)) shooter.changeHGV(-10);

        if(buttonChecker.get(dpad_left)) shooter.changePSV(-10);

        if(buttonChecker.get(dpad_right)) shooter.changePSV(10);

        telemetry.addData("Velocity: ", shooter.getVelocity());

        telemetry.addData("HGV: ", shooter.getHGV());
        telemetry.addData("PSV: ", shooter.getPSV());

//        TelemetryPacket packet = new TelemetryPacket();
//        packet.put("Velocity", currentVelocity);
//        packet.put("HighGoalVelocity", highGoalVelocity);
//        dashboard.sendTelemetryPacket(packet);



    }


}
