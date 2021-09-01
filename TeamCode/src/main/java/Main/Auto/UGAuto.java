package TeamCode.src.main.java.Main.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import Main.Base.AutoRobot;

@Autonomous(name = "Competition Auto", group = "competition")
public class UGAuto extends AutoRobot {

    double speed = 0.6;

    double error = 4;

    public void runAutonomous(){

        try {

            wobbleArm.setWobbleArmInPosition();
            wobbleArm.ControlWobbleClaw(true);

            if(rings == 0) {

                wheelBase.goToPosition(odometry,  gyro, 56, 0, 0, speed, error);
                wobbleArm.ControlWobbleArm(true);
                pause(1000);
                wobbleArm.ControlWobbleClaw(false);
                pause(1000);
                wobbleArm.ControlWobbleArm(false);
                pause(2000);
                wheelBase.goToPosition(odometry,  gyro, 60, 13, 0, 0.3, 1);
                shooter.shoot(true, 3);
                pause(1000);
                wheelBase.goToPosition(odometry,  gyro, 66, 14, 0, speed, error);

            }

            else if(rings == 1) {

                wheelBase.goToPosition(odometry, gyro, 56, 0, 0, speed, error);
                wheelBase.goToPosition(odometry,  gyro, 60, 13, 0, 0.3, 1);
                shooter.shoot(true, 3);
                pause(1000);
                wheelBase.goToPosition(odometry,  gyro, 37, 0, 0,  speed, 3);
                intake.controlLIntake(true, false);
                wheelBase.goToPosition(odometry, gyro, 37, 14, 0, 0.5, 2);
                wheelBase.goToPosition(odometry, gyro, 55, 14, 0, speed, error);
                wheelBase.goToPosition(odometry,  gyro, 60, 13, 0, 0.4, 1);
                shooter.shoot(true, 3);
                intake.controlLIntake(false, false);
                wheelBase.goToPosition(odometry, gyro, 80, 21, 0, speed, error);
                wobbleArm.ControlWobbleArm(true);
                pause(1000);
                wobbleArm.ControlWobbleClaw(false);
                pause(1000);
                wobbleArm.ControlWobbleArm(false);
                wheelBase.goToPosition(odometry,  gyro, 67, 14, 0, speed, error);

            }

            else if(rings == 4) {


                wheelBase.goToPosition(odometry, gyro, 56, 0, 0, speed, error);
                wheelBase.goToPosition(odometry,  gyro, 60, 13, 0, 0.3, 1);
                shooter.shoot(true, 3);
                pause(1000);
                wheelBase.goToPosition(odometry,  gyro, 37, 0, 0,  speed, 3);
                intake.controlLIntake(true, false);
                wheelBase.goToPosition(odometry, gyro, 37, 14, 0, 0.3, 2);
                wheelBase.goToPosition(odometry, gyro, 55, 14, 0, speed, error);
                wheelBase.goToPosition(odometry,  gyro, 60, 13, 0, 0.4, 1);
                shooter.shoot(true, 3);
                pause(500);
                intake.controlLIntake(false, true);
                wheelBase.goToPosition(odometry,  gyro, 37, 0, 0,  speed, 3);
                intake.controlLIntake(true, false);
                wheelBase.goToPosition(odometry, gyro, 37, 14, 0, speed, 2);
                wheelBase.goToPosition(odometry, gyro, 37, 28, 0, 0.5, 2);
                wheelBase.goToPosition(odometry, gyro, 55, 14, 0, speed, error);
                wheelBase.goToPosition(odometry,  gyro, 60, 13, 0, 0.4, 1);
                shooter.shoot(true, 3);
                intake.controlLIntake(false, false);
                wheelBase.goToPosition(odometry, 98, 5, 0.8, error);
                wobbleArm.ControlWobbleArm(true);
                pause(250);
                wobbleArm.ControlWobbleClaw(false);
                pause(500);
                wobbleArm.ControlWobbleArm(false);
                wheelBase.goToPosition(odometry,  67, 14, speed, error);

            }


        }catch(Exception e){
            autoThread.interrupt();
            telemetry.addData("AUTONOMOUS WAS INTERRUPTED", e);
        }
    }
}
