package TeamCode.src.main.java.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import Main.Base.Hardware;
import Main.Base.Robot;

@TeleOp(name = "EncoderTest", group = "testing")
public class EncoderTest extends Robot {
    double lf, rf, lb, rb;

    @Override
    public void start() {
        wheelBase.setModeAll(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {



        lf = leftFront.getCurrentPosition();
        rf = rightFront.getCurrentPosition();
        lb = leftBack.getCurrentPosition();
        rb = rightBack.getCurrentPosition();

        telemetry.addData("LF Motor Pos: ",  lf);
        telemetry.addData("RF Motor Pos: ",  rf);
        telemetry.addData("LB Motor Pos: ",  lb);
        telemetry.addData("RB Motor Pos: ",  rb);

        telemetry.update();
    }



}
