package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Q01_CookiesExceptionJSAlertFilesWait extends TestBase {
/*
    Go to https://yasinanil67.github.io/CookiesWait
    Accept the alert
    Accept the cookies
    Assert that there are 10 cookies
    Print sessionToken cookie value
    Click on 'Go to Files'
    Take a screenshot of the files page and attach it to the report
    Click on 'Download' and verify that the file is downloaded
    Upload a file
    Click on 'Submit' and verify that the file is uploaded
*/

    @Test
    public void test01() throws InterruptedException {

//        Go to https://yasinanil67.github.io/CookiesWait
        driver.get("https://yasinanil67.github.io/CookiesWait");

//        Accept the alert
        try {
            driver.switchTo().alert().accept();
        } catch (Exception _) {
            System.out.println("Alert did not appear.");
        }

//        Accept the cookies
        driver.findElement(By.id("acceptCookiesButton")).click();

//        Assert that there are 10 cookies
        int numOfCookies = driver.manage().getCookies().size();
        assertEquals(10, numOfCookies);

//        Print sessionToken cookie value
        String sessionToken = driver.manage().getCookieNamed("sessionToken").getValue();
        System.out.println("sessionToken = " + sessionToken);

//        Click on 'Go to Files'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement delayedButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("delayedButton")));
        delayedButton.click();

//        Take a screenshot of the files page and attach it to the report
        passAndTakeScreenshot("User is on the file page");

//        Click on 'Download' and verify that the file is downloaded
        driver.findElement(By.linkText("Download")).click();

        Thread.sleep(3000);
        assert Files.exists(Path.of(System.getProperty("user.home") + "\\Downloads\\QAProgram.png"));

//        Upload a file
        driver.findElement(By.id("uploadInput")).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\CV.pdf");

//        Click on 'Submit' and verify that the file is uploaded
        driver.findElement(By.xpath("//*[.='Submit']")).click();
        String successMessage = driver.findElement(By.id("successBox")).getText();
        assertEquals("File uploaded successfully!", successMessage);

    }

}
