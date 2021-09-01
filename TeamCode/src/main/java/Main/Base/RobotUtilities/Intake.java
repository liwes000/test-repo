package TeamCode.src.main.java.Main.Base.RobotUtilities;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {

    /** + Powers will intake in, - Numbers will spit out**/

    private DcMotor leftIntake;
    private DcMotor rightIntake;

    public Intake(DcMotor lI, DcMotor rI) {
        leftIntake = lI;
        rightIntake = rI;

        leftIntake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightIntake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    public void setLRIntakePower(double leftPower, double rightPower) {
        leftIntake.setPower(leftPower);
        rightIntake.setPower(rightPower);
    }


    public void setLIntakePower(double leftPower) {
        leftIntake.setPower(leftPower);
    }


    public void setRIntakePower(double rightPower) {
        rightIntake.setPower(rightPower);
    }


    public void lIntakeIn() {leftIntake.setPower(1);}


    public void lSpitOut() {leftIntake.setPower(-1);}


    public void rIntakeIn() {rightIntake.setPower(1);}


    public void rSpitOut() {rightIntake.setPower(-1);}


    public void controlLIntake(boolean intakeIn, boolean intakeOut) {
        if(intakeIn) leftIntake.setPower(1);
        else if(intakeOut) leftIntake.setPower(-1);
        else leftIntake.setPower(0);
    }

    public void controlRIntake(boolean intakeIn, boolean intakeOut) {
        if(intakeIn) rightIntake.setPower(1);
        else if(intakeOut) rightIntake.setPower(-1);
        else rightIntake.setPower(0);
    }

    public void controlLRIntake(boolean intakeIn, boolean intakeOut) {
        if(intakeIn) {
            leftIntake.setPower(1);
            rightIntake.setPower(1);
        }
        else if(intakeOut){
            leftIntake.setPower(-1);
            rightIntake.setPower(-1);
        }
        else{
            leftIntake.setPower(0);
            rightIntake.setPower(0);
        }
    }
}
