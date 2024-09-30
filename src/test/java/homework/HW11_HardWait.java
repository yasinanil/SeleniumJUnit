package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class HW11_HardWait extends TestBase {
/*
   Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
   Click on "click me" button
   Verify that "Event Triggered"
*/

    @Test
    public void test11() throws InterruptedException {

//        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

//        Click on "click me" button
        Thread.sleep(4000);
        driver.findElement(By.id("growbutton")).click();


//        Verify that "Event Triggered"
        String status = driver.findElement(By.id("growbuttonstatus")).getText();
        assertEquals("Event Triggered", status);

    }
}
