package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HW04_RegisterUser extends TestBase {
/*
    Go to https://yasinanil67.github.io/homepage
    Click on user icon
    Click on Register
    Fill the form and click on Login
    Enter username and password you created
    Assert success message
    Celebrate the login :)
*/

    @Test
    public void registerTest() {
//        Go to https://yasinanil67.github.io/homepage
        driver.get("https://yasinanil67.github.io/homepage");

//        Click on user icon
        driver.findElement(By.id("userIcon")).click();

//        Click on Register
        driver.findElement(By.linkText("Register")).click();

//        Fill the form and click on Login

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
        String username = "johndoe";
        driver.findElement(By.id("username")).sendKeys(username);
//        Enter Email
        driver.findElement(By.id("email")).sendKeys("john@gmail.com");
//        Enter New password
        String password = "123";
        driver.findElement(By.id("password")).sendKeys(password);
//        Enter New password confirmation
        driver.findElement(By.id("confirm-password")).sendKeys("123");
//        Click on Register button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//button[@class='login-button']")).click();

//        Enter username and password you created

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password + Keys.ENTER);


//        Assert success message
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        assertEquals("Login Successful!", successMessage);

//        Celebrate the login :)
        driver.findElement(By.id("clickMeButton")).click();


    }

}
