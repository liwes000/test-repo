package TeamCode.src.main.java.Main.Base.RobotUtilities;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Shooter {

    /** Reverse flyWheel motor so positive powers will shoot out **/

    private DcMotorEx flyWheel;

    private Servo feederServo;

    double feederServoFeedPosition = 0.0;
    double feederServoPrepPosition = 0.25;
    double feederServoPosition = feederServoPrepPosition;

    public static double highGoalVelocity = 1000;
    public static double powerShotVelocity = 250;

    double TICKS_PER_REV = 28;

    private ElapsedTime runTime = new ElapsedTime();

    public Shooter(DcMotorEx fwMotor, Servo fServo) {
        flyWheel = fwMotor;
        feederServo = fServo;

        flyWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void shoot(boolean highGoal, int times){

        double velocity;
        if(highGoal) velocity = highGoalVelocity;
        else velocity = powerShotVelocity;

        resetShooter();
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        runTime.reset();
        flyWheel.setVelocity(velocity);

        runTime.reset();
        while(runTime.milliseconds() < 1000) { }

        for(int i = 0; i < times; i++) {
            feedShooter();
            resetShooter();
        }
        resetShooter();
        flyWheel.setVelocity(0);
        flyWheel.setPower(0);
    }


    public void feedShooter() {
        runTime.reset();

        while (runTime.milliseconds() > 0 && runTime.milliseconds() < 250 ) {
            feederServo.setPosition(feederServoFeedPosition);
        }
    }

    public void resetShooter() {
        runTime.reset();

        while (runTime.milliseconds() > 0 && runTime.milliseconds() < 250 ) {
            feederServo.setPosition(feederServoPrepPosition);
        }

    }


    public void setFeederServoPosition(boolean feed) {
        if(feed) feederServoPosition = feederServoFeedPosition;
        else feederServoPosition = feederServoPrepPosition;

        feederServo.setPosition(feederServoPosition);
    }


    public void runFlywheels(boolean spinning) {
        if(spinning) {
            flyWheel.setPower(1);
        }
        else {
            flyWheel.setPower(0);
        }
    }

    public void setFlywheelPower(double velocity, boolean on) {

        if (on) {
        flyWheel.setVelocity(velocity);
        }
        else flyWheel.setPower(0);

    }

    public void runFlyWheel(double v) {
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flyWheel.setVelocity(v);
    }

    public void runFlyWheelHigh() {
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flyWheel.setVelocity(highGoalVelocity);
    }


    public void stopFlyWheel() {
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flyWheel.setPower(0);
    }

    public void runFlyWheelPower() {
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flyWheel.setVelocity(powerShotVelocity);
    }

    public double getVelocity(){
       return flyWheel.getVelocity();
    }

    public void changePSV(double num){
        powerShotVelocity += num;
    }

    public double getPSV(){
        return powerShotVelocity;
    }

    public void changeHGV(double num){
        highGoalVelocity += num;
    }

    public double getHGV(){
        return highGoalVelocity;
    }

}