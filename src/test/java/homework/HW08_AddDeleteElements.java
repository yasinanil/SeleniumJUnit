package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HW08_AddDeleteElements extends TestBase {
/*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
*/

    @Test
    public void addDeleteTest() {
//        Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

//        Click on the "Add Element" button 100 times
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));

        int add = 100;

        for (int i = 0; i < add; i++) {
            addElementButton.click();
        }

//        Click on the "Delete" button 20 times
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));

        int delete = 20;

        for (int i = 0; i < delete; i++) {
            deleteButtons.get(i).click();
        }

//        Assert that 20 buttons were deleted.
        assertEquals(add - delete, driver.findElements(By.xpath("//button[.='Delete']")).size());
    }
}
