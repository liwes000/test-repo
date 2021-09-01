package TeamCode.src.main.java.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Main.Base.Robot;

@Disabled
@TeleOp(name = "WheelBase Test", group = "TeamCode.src.main.java.test")
public class WheelBaseTest extends Robot {

    @Override
    public void loop() {
        wheelBase.mecanumDrive(gp.left_stick_x, -gp.left_stick_y, gp.right_stick_x, false);
    }
}
