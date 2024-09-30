package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HW14_SeleniumWait extends TestBase {
/*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
 */

    @Test
    public void test14(){

//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeFullPageScreenshot();

//        Click on Ajax Loader
        driver.findElement(By.id("button3")).click();
        takeFullPageScreenshot();

//        Click on "Click Me!" button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button1"))).click();
        takeFullPageScreenshot();

        //driver.findElement(By.id("button1")).click();

//        Assert that button is clicked
        assert driver.findElement(By.tagName("h4")).getText().contains("Well Done");

//        Take screenshot after each step


    }


}
