package TeamCode.src.main.java.Main.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import Main.Base.AutoRobot;

@Disabled
@Autonomous(name = "B", group = "testing")
public class AutoB extends AutoRobot {

    double speed = 0.5;

    double error = 4;

    public void runAutonomous(){

        try {

//            wheelBase.goToPosition(odometry,  0, 48, speed, 4);
//            wheelBase.goToPosition(odometry,  0, 24, speed, 4);


            wobbleArm.setWobbleArmInPosition();
            wobbleArm.ControlWobbleClaw(true);
            wheelBase.goToPosition(odometry, 56, 0, speed, error);
            wheelBase.goToPosition(odometry,  80, 21, speed, error);
            wobbleArm.ControlWobbleArm(true);
            pause(1000);
            wobbleArm.ControlWobbleClaw(false);
            pause(1000);
            wobbleArm.ControlWobbleArm(false);
            wheelBase.goToPosition(odometry,  57, 14, speed, error);
            shooter.shoot(true, 3);
            pause(1000);
            wheelBase.goToPosition(odometry,  40, 0, speed, error);
            intake.controlLIntake(true, false);
            wheelBase.goToPosition(odometry, 40, 10, speed, error);
            wheelBase.goToPosition(odometry,  58, 10, speed, error);
            shooter.shoot(true, 3);
            intake.controlLIntake(false, false);
            wheelBase.goToPosition(odometry,  67, 14, speed, error);
//            pause(1000);
//            wheelBase.goToPosition(odometry,  24, 18, speed, 4);
//            pause(1000);
//            wheelBase.goToPosition(odometry,  6, 36, speed, 4);
//            pause(1000);
//            wheelBase.goToPosition(odometry,  76, 36, speed, 4);
//            pause(1000);
//            wheelBase.goToPosition(odometry,  76, 0, speed, 4);
//            pause(1000);
//            wheelBase.goToPosition(odometry,  73, 0, speed, 4);


        }catch(Exception e){
            autoThread.interrupt();
            telemetry.addData("AUTONOMOUS WAS INTERRUPTED", e);
        }
    }


}
