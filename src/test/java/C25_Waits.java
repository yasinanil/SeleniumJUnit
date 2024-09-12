import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C25_Waits {

    WebDriver driver;

    @Test
    public void implicitWaitTest() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://yasinanil67.github.io/homepage");

        driver.findElement(By.id("userIcon")).click();

        driver.findElement(By.linkText("Register")).click();

        driver.quit();

    }

    @Test
    public void explicitWaitTest() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://yasinanil67.github.io/homepage");

        driver.findElement(By.id("userIcon")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));

        element.click();

        driver.quit();

    }

    @Test
    public void fluentWaitTest() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://yasinanil67.github.io/Wait");

        //driver.findElement(By.id("elementID")).click(); //ElementNotInteractableException

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));

        element.click();

        assertTrue(driver.findElement(By.id("successMessage")).isDisplayed());

        Thread.sleep(3000);

        driver.quit();
    }


}
