package TeamCode.src.main.java.Testing;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Main.Base.Odometry.OdometryPositionUpdater;
import Main.Base.Robot;

@TeleOp(name = "Odometry Test", group = "testing")
public class OdometryTest extends Robot {


//    OdometryPositionUpdater globalPositionUpdate;
//    Thread positionThread;

    OdometryPositionUpdater globalPositionUpdate = new OdometryPositionUpdater(left, right, mid, gyro, 75);
    Thread positionThread = new Thread(globalPositionUpdate);

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void start() {
        positionThread.start();
    }


    @Override
    public void loop(){
        wheelBase.mecanumDrive(-gp.left_stick_y, -gp.left_stick_x, gp.right_stick_x, false);

//        telemetry.addData("X Position", globalPositionUpdate.returnXCoordinate());
//        telemetry.addData("Y Position", globalPositionUpdate.returnYCoordinate());
//        telemetry.addData("Orientation (Degrees)", globalPositionUpdate.returnOrientation());
//        telemetry.addData("Thread Active", positionThread.isAlive());
//        telemetry.update();
    }


//    @Override
//    public void stop(){globalPositionUpdate.stop();}

}
