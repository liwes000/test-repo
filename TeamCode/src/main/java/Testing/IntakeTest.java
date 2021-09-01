package TeamCode.src.main.java.Testing;

import androidx.appcompat.app.ActionBar;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Main.Base.Robot;

@Disabled
@TeleOp(name = "Intake Test", group = "TeamCode.src.main.java.test")
public class IntakeTest extends Robot {

    @Override
    public void loop() {
        if(gp.left_trigger > 0.1) intake.setLIntakePower(0.5);
        else if(gp.left_bumper) intake.setLIntakePower(-0.5);
        else intake.setLIntakePower(0);

        if(gp.right_trigger > 0.1) intake.setRIntakePower(0.5);
        else if(gp.right_bumper) intake.setRIntakePower(-0.5);
        else intake.setRIntakePower(0);
    }
}
