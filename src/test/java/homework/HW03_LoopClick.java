package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HW03_LoopClick extends TestBase {
/*
    Go to https://yasinanil67.github.io/deleteChars.
    Enter a string into the input field.
    Click the "Delete" button to remove the string.
    Verify that the success message 'Deleted' is displayed.
*/

    @Test
    public void loopClickTest() {

        driver.get("https://yasinanil67.github.io/deleteChars");

        String text = "Hello World";

        driver.findElement(By.id("inputText")).sendKeys(text);

        driver.findElement(By.id("enterButton")).click();

        WebElement deleteButton = driver.findElement(By.id("deleteButton"));


        for (int i = 0; i < text.length(); i++) {
            deleteButton.click();
        }

        assert driver.findElement(By.id("deletedMessage")).isDisplayed();//Java assertion

    }
}
