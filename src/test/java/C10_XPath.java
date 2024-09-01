import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C10_XPath {

    WebDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Dynamic wait

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void xpathTest() throws InterruptedException {

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        Thread.sleep(2000);
        email.sendKeys("talentifylab@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Thread.sleep(2000);
        password.sendKeys("Talentify.123");

        password.submit();

        WebElement logout = driver.findElement(By.xpath("//button[.='Logout']"));
        boolean isDisplayed = logout.isDisplayed();
        assertTrue(isDisplayed);

        String lastPTag = driver.findElement(By.xpath("(//p)[last()]")).getText();
        System.out.println("lastPTag = " + lastPTag);

    }
}
