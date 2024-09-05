import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C19_ActionsClass extends TestBase {

    @Test
    public void hoverOverTest() throws InterruptedException {

        driver.get("https://www.browserstack.com/");

        WebElement products = driver.findElement(By.id("products-dd-toggle"));

        Actions actions = new Actions(driver);

        Thread.sleep(3000);
        actions.moveToElement(products).perform();

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[.='Browser automation grid'])[1]")).click();

        assertEquals("https://www.browserstack.com/automate", driver.getCurrentUrl());

    }

    @Test
    public void dragAndDropTest() throws InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/drag-drop-javascript.html");

        Actions actions = new Actions(driver);

        WebElement draggable1 = driver.findElement(By.id("draggable1"));
        WebElement droppable1 = driver.findElement(By.id("droppable1"));

        Thread.sleep(3000);
        actions.dragAndDrop(draggable1, droppable1).perform();

        assert driver.findElement(By.xpath("//p[.='Dropped!']")).isDisplayed();

    }


    @Test
    public void clickTest(){

        driver.get("https://testpages.eviltester.com/styled/events/javascript-events.html");

        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));

        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));

        Actions actions = new Actions(driver);

        actions
                .pause(2000)
                .contextClick(oncontextmenu)
                .pause(2000)
                .doubleClick(ondoubleclick)
                .perform();

    }


}
