package TeamCode.src.main.java.Main.Auto;

import Main.Base.AutoRobot;

public class TemplateAuto extends AutoRobot {

    double speed = 0.5;

    double error = 4;

    public void runAutonomous(){

        try {


        }catch(Exception e){
            autoThread.interrupt();
            telemetry.addData("AUTONOMOUS WAS INTERRUPTED", e);
        }
    }
}
