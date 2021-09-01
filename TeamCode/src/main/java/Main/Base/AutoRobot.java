package TeamCode.src.main.java.Main.Base;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvInternalCamera;

import Main.Base.Robot;
import Main.Base.RobotUtilities.Camera;
import Main.Base.RobotUtilities.Gyro;
import Main.Base.RobotUtilities.Intake;
import Main.Base.RobotUtilities.Odometry;
import Main.Base.RobotUtilities.Shooter;
import Main.Base.RobotUtilities.WheelBase;
import Main.Base.RobotUtilities.WobbleArm;

public abstract class AutoRobot extends Hardware {


    public Camera camera;
    public Gyro gyro;
    public WheelBase wheelBase;
    public Shooter shooter;
    public WobbleArm wobbleArm;
    public Intake intake;
    public Odometry odometry;

    public Thread positionThread;

    protected Thread autoThread = new Thread(new Runnable() {
        @Override
        public void run() {
            runAutonomous();
        }
    });


    public int rings = -1;

    @Override
    public void init() {


        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        OpenCvInternalCamera phoneCamera = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        camera = new Camera(phoneCamera);


        imu = hardwareMap.get(BNO055IMU.class, imuName);

        gyro = new Gyro(imu);


        leftFront = hardwareMap.dcMotor.get(leftFrontName);
        leftBack = hardwareMap.dcMotor.get(leftBackName);
        rightBack = hardwareMap.dcMotor.get(rightBackName);
        rightFront = hardwareMap.dcMotor.get(rightFrontName);

        left = hardwareMap.dcMotor.get(leftName);
        right = hardwareMap.dcMotor.get(rightName);
        mid = hardwareMap.dcMotor.get(midName);

        wheelBase = new WheelBase(leftFront, leftBack, rightFront, rightBack);


        leftIntake = hardwareMap.dcMotor.get(leftIntakeName);
        rightIntake = hardwareMap.dcMotor.get(rightIntakeName);

        intake = new Intake(leftIntake, rightIntake);


        flyWheel = hardwareMap.get(DcMotorEx.class, flyWheelName);

        feederServo = hardwareMap.servo.get(feederServoName);

        shooter = new Shooter(flyWheel, feederServo);


        wobbleArmServo = hardwareMap.servo.get(wobbleArmServoName);
        wobbleClaw = hardwareMap.servo.get(wobbleClawName);

        wobbleArm = new WobbleArm(wobbleArmServo, wobbleClaw);

        odometry = new Odometry(left, right, mid,  50);
        positionThread = new Thread(odometry);
        positionThread.start();

        camera.startStreaming();

    }


    @Override
    public void init_loop() {
        rings = camera.detectRings();
        telemetry.addData("Rings: ", rings);
        telemetry.update();
    }


    @Override
    public void start() {
        autoThread.start();
    }


    @Override
    public void loop() {
        telemetry.addData("X Position", odometry.returnXCoordinateInches());
        telemetry.addData("Y Position", odometry.returnYCoordinateInches());
        telemetry.addData("Orientation (Degrees)", gyro.getHeading());
        telemetry.update();
    }


    @Override
    public void stop() {
        try {
            autoThread.join();
            autoThread.interrupt();
        } catch (Exception e) {
            telemetry.addData("ENCOUNTERED AN EXCEPTION", e);
        }

    }


    protected void pause(long millis) {
        long maxTime;
        maxTime = System.currentTimeMillis() + millis;
        while (System.currentTimeMillis() < maxTime && !autoThread.isInterrupted()) {
        }
    }


    public abstract void runAutonomous();

}
