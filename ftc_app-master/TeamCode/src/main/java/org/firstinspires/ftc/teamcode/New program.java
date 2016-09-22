import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class pushbotteleoptank_iterative extends Opmode {
    private ElapsedTime runtime = new ElapsedTime ();
    dcmotor FlipperMotor;
}

private ElapsedTime runtime = new ElapsedTime();
DcMotor leftMotorFront;
DcMotor rightMotorFront;
DcMotor leftMotorBack;
DcMotor rightMotorback;
double leftMotorFront(0);
double