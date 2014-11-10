import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.Robot;

public class fuck {
	public static void main(String [] argv){
	try {
        Robot robot = new Robot();
        Thread.sleep(2000);
        // Simulate a key press
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

} catch (AWTException e) {
        e.printStackTrace();
        System.err.println("Error!! bam!");
} catch (InterruptedException e) {
	System.err.println("Timer didnt work !");
	e.printStackTrace();
}
	}
}
