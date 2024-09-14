import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C27_Screenshot extends TestBase {

    @Test
    public void fullPageScreenshotTest() throws IOException {

        driver.get("https://talentifylab.com");

        File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        File target = new File("test-outputs/screenshots/fullPageScreenshot"+timestamp+".png");

        Files.copy(ss.toPath(), target.toPath());

    }

    @Test
    public void specificElementsScreenshotTest() throws IOException {

        driver.get("https://google.com");

        File ss = driver.findElement(By.xpath("//img[@class='lnXdpd']")).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        File target = new File("test-outputs/screenshots/elementsScreenshot"+timestamp+".png");

        Files.copy(ss.toPath(), target.toPath());

    }

    @Test
    public void takeScreenshotUtilsTest()  {

        driver.get("https://talentifylab.com");

        takeFullPageScreenshot();

        WebElement image = driver.findElement(By.xpath("(//img[@alt='Hero Background People'])[1]"));

        takeSpecificElementsScreenshot(image);

    }




}
