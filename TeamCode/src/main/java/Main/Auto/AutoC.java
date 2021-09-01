package TeamCode.src.main.java.Main.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import Main.Base.AutoRobot;

@Disabled
@Autonomous(name = "C", group = "testing")
public class AutoC extends AutoRobot {

    double speed = 0.6;

    double error = 4;

    public void runAutonomous(){

        try {


            wobbleArm.setWobbleArmInPosition();
            wobbleArm.ControlWobbleClaw(true);
            wheelBase.goToPosition(odometry, 98, 0, 0.8, error);
            wobbleArm.ControlWobbleArm(true);
            pause(250);
            wobbleArm.ControlWobbleClaw(false);
            pause(500);
            wobbleArm.ControlWobbleArm(false);
            wheelBase.straighten(odometry, 0.15);
            wheelBase.goToPosition(odometry,  57, 14, speed, error);
            shooter.shoot(true, 3);
            pause(500);
            wheelBase.goToPosition(odometry,  38, 0, speed, error);
            //wheelBase.straighten(odometry, 0.1);
            wheelBase.goToPosition(odometry, 38, 19, speed, error);
            pause(500);
            intake.controlLIntake(true, false);
            wheelBase.goToPosition(odometry, 38, 28, 0.2, error);
            pause(500);
            wheelBase.goToPosition(odometry,  56, 18, speed, error);
            shooter.shoot(true, 3);
            intake.controlLIntake(false, true);
            wheelBase.goToPosition(odometry,  45, 0, speed, error);
            intake.controlLIntake(true, false);
            wheelBase.goToPosition(odometry, 48, 24, speed, error);
            wheelBase.goToPosition(odometry, 48, 44, 0.2, error);
            wheelBase.goToPosition(odometry,  56, 18, speed, error);
            shooter.shoot(true, 3);
            intake.controlLIntake(false, false);
            wheelBase.goToPosition(odometry,  67, 14, speed, error);

        }catch(Exception e){
            autoThread.interrupt();
            telemetry.addData("AUTONOMOUS WAS INTERRUPTED", e);
        }
    }


}
