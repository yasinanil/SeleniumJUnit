package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void takeFullPageScreenshotTest() {

        File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        File target = new File("test-outputs/screenshots/fullPageScreenshot"+timestamp+".png");

        try {
            Files.copy(ss.toPath(), target.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void takeSpecificElementsScreenshot(WebElement element) {

        File ss = element.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        File target = new File("test-outputs/screenshots/elementsScreenshot"+timestamp+".png");

        try {
            Files.copy(ss.toPath(), target.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
