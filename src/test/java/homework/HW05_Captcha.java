package homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class HW05_Captcha extends TestBase {

    /*
        Go to https://form.jotform.com/73302671092956
        Click on start
        Enter firstname and lastname
        Click on next
        Enter email
        Click on next
        Enter message
        Click on next
        Handle captcha
        Click on submit
        Assert that submission is received
    */
    @Test
    public void captchaTest() {
//        Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");

//        Click on start
        driver.findElement(By.id("jfCard-welcome-start")).click();

//        Enter firstname and lastname
        driver.findElement(By.id("first_1")).sendKeys("John");
        driver.findElement(By.id("last_1")).sendKeys("Doe");

//        Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_0']")).click();

//        Enter email
        driver.findElement(By.id("input_2")).sendKeys("john@doe.com");

//        Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_1']")).click();

//        Enter message
        driver.findElement(By.id("input_3")).sendKeys("Hello World");

//        Click on next
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();

//        Handle captcha

        driver.switchTo().frame(0);

        int number1 = Integer.parseInt(driver.findElement(By.id("number")).getText());
        int number2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
        String function = driver.findElement(By.id("function")).getText();
        int result = 0;

        if (function.equals("+")) {
            result = number1 + number2;
        } else if (function.equals("-")) {
            result = number1 - number2;
        } else {
            result = number1 * number2;
        }

        driver.findElement(By.xpath("//input[@name='equal']")).sendKeys(result + "");

//        Click on submit

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//*[.='Submit'])[4]")).click();


//        Assert that submission is received

        assert driver.findElement(By.tagName("h1")).getText().contains("Thank You");


    }


}
