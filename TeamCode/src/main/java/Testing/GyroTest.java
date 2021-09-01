package TeamCode.src.main.java.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Main.Base.Robot;

@TeleOp(name = "Gyro Test", group = "TeamCode.src.main.java.test")
public class GyroTest extends Robot {

    @Override
    public void loop() {

        telemetry.addData("Heading: ", gyro.getHeading());
    }
}
