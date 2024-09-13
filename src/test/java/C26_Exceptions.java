import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C26_Exceptions extends TestBase {

    WebDriver webDriver;

    @Test
    public void noSuchElementExceptionTest(){

        driver.get("https://talentifylab.com");

        driver.findElement(By.linkText("Login or SignupX")).click();//NoSuchElementException

    }

    @Test
    public void timeoutExceptionTest(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://talentifylab.com");

        By byObject = By.linkText("Login or SignupX");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byObject));//TimeoutException

        element.click();

    }

    @Test
    public void staleElementReferenceExceptionTest(){

        driver.get("https://talentifylab.com");

        WebElement login = driver.findElement(By.linkText("Login or Signup"));

        login.click();

        driver.get("https://google.com");

        driver.get("https://talentifylab.com");

        //login = driver.findElement(By.linkText("Login or Signup"));

        login.click();//StaleElementReferenceException

    }

    @Test
    public void elementNotInteractableExceptionTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://yasinanil67.github.io/Wait");

        driver.findElement(By.id("elementID")).click();//ElementNotInteractableException


    }

    @Test
    public void webDriverExceptionTest() {

        driver.get("https://yasinanil67.github.io/Wait");

        driver.close();

        driver.navigate().refresh();//NoSuchSessionException

    }

    @Test
    public void nullPointerExceptionTest(){

        //webDriver = new ChromeDriver();

        webDriver.get("https://yasinanil67.github.io/Wait");//NullPointerException

        webDriver.close();

    }

}
