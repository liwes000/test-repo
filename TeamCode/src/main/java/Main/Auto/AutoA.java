package TeamCode.src.main.java.Main.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import Main.Base.AutoRobot;

@Disabled
@Autonomous(name = "A", group = "testing")
public class AutoA extends AutoRobot {

    double speed = 0.5;

    double error = 4;

    public void runAutonomous(){

        try {


            wobbleArm.setWobbleArmInPosition();
            wobbleArm.ControlWobbleClaw(true);
            wheelBase.goToPosition(odometry,  56, 0, speed, 4);
            wobbleArm.ControlWobbleArm(true);
            pause(1000);
            wobbleArm.ControlWobbleClaw(false);
            pause(1000);
            wobbleArm.ControlWobbleArm(false);
            wheelBase.goToPosition(odometry,  58, 10, speed, 4);
            shooter.shoot(true, 3);
            pause(1000);
            wheelBase.goToPosition(odometry,  66, 14, speed, 4);


        }catch(Exception e){
            autoThread.interrupt();
            telemetry.addData("AUTONOMOUS WAS INTERRUPTED", e);
        }
    }


}
