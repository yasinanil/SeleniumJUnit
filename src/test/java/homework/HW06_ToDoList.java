package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW06_ToDoList extends TestBase {
/*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
*/

    @Test
    public void toDoListTest() throws InterruptedException {

        //Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> toDolist = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        WebElement input = driver.findElement(By.tagName("input"));

        for (String w : toDolist) {
            input.sendKeys(w + Keys.ENTER);
        }

        //Strikethrough all todos.
        List<WebElement> listItems = driver.findElements(By.tagName("li"));

        listItems.forEach(WebElement::click);

        //Delete all todos.
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));

        deleteButtons.forEach(WebElement::click);

        //Assert that all todos deleted.

        Thread.sleep(500);
        assert driver.findElements(By.xpath("//i[@class='fa fa-trash']")).isEmpty();

    }
}
