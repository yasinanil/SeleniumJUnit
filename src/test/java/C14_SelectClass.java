import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C14_SelectClass extends TestBase {

    @Test
    public void selectClassTest() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        WebElement dropDown = driver.findElement(By.xpath("//select[@name='dropdown']"));

        Select select = new Select(dropDown);

        Thread.sleep(3000);
        select.selectByIndex(4);

        Thread.sleep(2000);
        select.selectByVisibleText("Drop Down Item 1");

        Thread.sleep(2000);
        select.selectByValue("dd6");

        boolean isMultiple = select.isMultiple();
        System.out.println("isMultiple = " + isMultiple);

        List<WebElement> allOptions = select.getOptions();
        allOptions.forEach(t-> System.out.println(t.getText()));//Lambda Expression

        WebElement multipleDD = driver.findElement(By.xpath("//select[@multiple='multiple']"));
        Select select2 = new Select(multipleDD);
        System.out.println(select2.isMultiple());

        select2.deselectAll();

        Thread.sleep(2000);
        select2.selectByIndex(0);
        Thread.sleep(2000);
        select2.selectByIndex(2);

        Thread.sleep(2000);
        select2.deselectAll();

    }
}
