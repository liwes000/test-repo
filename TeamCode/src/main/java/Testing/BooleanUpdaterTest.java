package TeamCode.src.main.java.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.HashMap;

import Main.Base.HelperClasses.BooleanUpdater;
import Main.Base.HelperClasses.Button;
import Main.Base.Robot;

import static Main.Base.HelperClasses.BooleanUpdater.updateBooleans;

@Disabled
@TeleOp(name = "BooleanUpdater Test", group = "testing")
public class BooleanUpdaterTest extends OpMode {

    HashMap<Button, Boolean> buttonChecker;

    public void init() {
        buttonChecker = new HashMap<Button, Boolean>();
    }


    @Override
    public void loop() {
        buttonChecker = updateBooleans(gamepad1, buttonChecker);

        telemetry.addData("a: ", buttonChecker.get(Button.a));

        telemetry.addData("Gamepad a: ", gamepad1.a);
    }


}
