import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class C23_RobotClass extends TestBase {

    @Test
    public void robotClassTest() throws AWTException, InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        // Click on the 'Choose File' button
        driver.findElement(By.xpath("(//tr)[4]")).click();

        // Set the file path to the clipboard
        StringSelection ss = new StringSelection(System.getProperty("user.home")+"\\Desktop\\flower.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // Create an instance of the Robot class
        Robot robot = new Robot();

        // Simulate pressing CTRL+V to paste the file path
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Simulate pressing ENTER to submit the file path
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Click the submit button to upload the file
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String fileName = driver.findElement(By.id("_valuefilename")).getText();

        assertEquals("flower.png",fileName);


    }
}
