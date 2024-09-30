package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class HW13_ClickTypes extends TestBase {
/*
   Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
   Click all the buttons and verify they are all clicked
*/

    @Test
    public void test13(){

//        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        WebElement onblur = driver.findElement(By.id("onblur"));
        WebElement onclick = driver.findElement(By.id("onclick"));
        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));

        new Actions(driver)
                .click(onblur)
                .click(onclick)
                .click(onclick)
                .contextClick(oncontextmenu)
                .doubleClick(ondoubleclick)
                .click(onfocus)
                .click(onkeydown)
                .sendKeys(Keys.SPACE)
                .click(onkeyup)
                .sendKeys(Keys.SPACE)
                .click(onkeypress)
                .sendKeys(Keys.SPACE)
                .moveToElement(onmouseover)
                .moveToElement(onmouseleave)
                .moveToElement(onmouseover)
                .click(onmousedown)
                .perform();


//        Click all the buttons and verify they are all clicked

        int triggers =driver.findElements(By.xpath("//*[.='Event Triggered']")).size();
        assertEquals(11, triggers);

    }


}
