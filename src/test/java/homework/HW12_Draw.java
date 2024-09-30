package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW12_Draw extends TestBase {
/*
    Go to https://yasinanil67.github.io/Draw
    Draw the line or shape you want on the screen
    Take the screenshot of shape
    Press the Reset button
*/

    @Test
    public void test12() {

//        Go to https://yasinanil67.github.io/Draw
        driver.get("https://yasinanil67.github.io/Draw");

//        Draw the line or shape you want on the screen
        WebElement board = driver.findElement(By.id("myCanvas"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(board);

        for (int i =0; i<20; i++){
            actions.moveByOffset(5, 0);
        }

        for (int i =0; i<20; i++){
            actions.moveByOffset(0, -5);
        }

        for (int i =0; i<20; i++){
            actions.moveByOffset(-5, 0);
        }

        for (int i =0; i<20; i++){
            actions.moveByOffset(0, 5);
        }

        for (int i =0; i<20; i++){
            actions.moveByOffset(5, -5).perform();
        }

//        Take the screenshot of shape
        takeSpecificElementsScreenshot(board);

//        Press the Reset button
        driver.findElement(By.id("resetButton")).click();


    }


}
