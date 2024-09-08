package practices.practice01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q04_FindElements extends TestBase {

/*
     Go to https://yasinanil67.github.io/addDeleteStar
     Click the star button a specific number of times.
     Click the delete button a specific number of times.
     Verify that the desired number of stars have been deleted.
*/

    @Test
    public void starTest() throws Exception {

        driver.get("https://yasinanil67.github.io/addDeleteStar");

        WebElement starButton = driver.findElement(By.id("push-button"));

        WebElement deleteButton = driver.findElement(By.id("delete-button"));

        int starClick = 200;
        int deleteClick = 195;

        if (deleteClick>starClick){
            throw new Exception("deleteClick can not be greater than starClick");
        }

        for (int i = 0; i < starClick; i++) {
            starButton.click();
        }

        for (int i = 0; i < deleteClick; i++) {
            deleteButton.click();
        }

        List<WebElement> starList = driver.findElements(By.className("star"));
        System.out.println("Number of Stars: " + starList.size());

        assertEquals(starClick - deleteClick, starList.size());

    }

}
