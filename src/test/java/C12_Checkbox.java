import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C12_Checkbox extends TestBase {

    @Test
    public void checkboxTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        Thread.sleep(3000);
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(1000);
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }

        assertTrue(checkBox1.isSelected() && checkBox2.isSelected());

    }

}
