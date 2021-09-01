package TeamCode.src.main.java.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Main.Base.Robot;


@TeleOp(name = "WobbleArm Test", group = "TeamCode.src.main.java.test")
public class WobbleArmTest extends Robot {

    boolean lastA = false, lastB = false, lastX = false, lastY = false;

    @Override
    public void loop() {

        if(gp.a && !lastA) wobbleArm.ControlWobbleArm(true);

        if(gp.b && !lastB) wobbleArm.ControlWobbleArm(false);

        if(gp.y && !lastY) wobbleArm.ControlWobbleClaw(true);

        if(gp.x && !lastX) wobbleArm.ControlWobbleClaw(false);


        if (gp.a) lastA = true;
        else lastA = false;

        if (gp.b) lastB = true;
        else lastB = false;

        if (gp.x) lastX = true;
        else lastX = false;

        if (gp.y) lastY = true;
        else lastY = false;

    }
}
