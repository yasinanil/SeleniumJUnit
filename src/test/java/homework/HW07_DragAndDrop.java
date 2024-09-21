package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW07_DragAndDrop extends TestBase {
    /*
      Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
      Match capitals with countries
    */
    @Test
    public void dragAndDropTest() {

//        Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

//        Match capitals with countries
        //Sources:
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        //Targets:
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement usa = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement korea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));


        new Actions(driver)
                .dragAndDrop(oslo, norway)

                .dragAndDrop(stockholm, sweden)

                .dragAndDrop(washington, usa)

                .dragAndDrop(copenhagen, denmark)

                .dragAndDrop(seoul, korea)

                .dragAndDrop(rome, italy)

                .dragAndDrop(madrid, spain)

                .perform();


    }

}
