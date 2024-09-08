package practices.practice01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Q03_BeforeAfterAnnotations {
/*
     Create chrome driver by using @Before annotation
     Go to url : https://yasinanil67.github.io/homepage
     Click on 'User Icon'
     Click on 'Register'
     Enter SSN
     Enter First Name
     Enter Last Name
     Enter Address
     Enter Phone Number
     Enter Username
     Enter Email
     Enter New password
     Enter New password confirmation
     Click on Register button
     Assert that user registered
     Close the browser by using @After annotation
*/

    //        Create chrome driver by using @Before annotation

    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //        Close the browser by using @After annotation
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void registerTest() throws InterruptedException {


//        Go to url : https://yasinanil67.github.io/homepage
        driver.get("https://yasinanil67.github.io/homepage");

//        Click on 'User Icon'
        WebElement userIcon = driver.findElement(By.id("userIcon"));
        userIcon.click();

//        Click on 'Register'
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

//        Enter SSN
        driver.findElement(By.id("ssn")).sendKeys("123");

//        Enter First Name
        driver.findElement(By.id("first-name")).sendKeys("John");
//        Enter Last Name
        driver.findElement(By.id("last-name")).sendKeys("Doe");
//        Enter Address
        driver.findElement(By.id("address")).sendKeys("New york");
//        Enter Phone Number
        driver.findElement(By.id("phone")).sendKeys("123");
//        Enter Username
        driver.findElement(By.id("username")).sendKeys("johndoe");
//        Enter Email
        driver.findElement(By.id("email")).sendKeys("john@gmail.com");
//        Enter New password
        driver.findElement(By.id("password")).sendKeys("123");
//        Enter New password confirmation
        driver.findElement(By.id("confirm-password")).sendKeys("123");
//        Click on Register button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        Assert that user registered
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        assertEquals("User registered successfully!", successMessage);

    }
}
