import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C16_JSAlert extends TestBase {

    @Test
    public void jSAlertTest() throws InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

        driver.findElement(By.id("alertexamples")).click();

        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.findElement(By.id("confirmexample")).click();
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        Thread.sleep(3000);
        driver.findElement(By.id("promptexample")).click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);
        String text = "Hello World";
        driver.switchTo().alert().sendKeys(text);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.id("promptreturn")).getText();

        assertEquals(text, actualText);

    }

}
