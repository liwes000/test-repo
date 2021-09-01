package TeamCode.src.main.java.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Main.Base.Robot;

@TeleOp(name = "Shooter Test", group = "TeamCode.src.main.java.test")
public class ShooterTest extends Robot {

    boolean lastA;

    @Override
    public void loop() {

        if (gp.a && !lastA) shooter.shoot(true, 3);

        if (gp.a) lastA = true;
        else lastA = false;

    }
}
