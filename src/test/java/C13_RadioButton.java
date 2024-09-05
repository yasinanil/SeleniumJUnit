import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C13_RadioButton extends TestBase {

    @Test
    public void radiobuttonTest() throws InterruptedException {

        driver.get("http://test.rubywatir.com/radios.php");

        WebElement radioId = driver.findElement(By.id("radioId"));

        Thread.sleep(3000);

        radioId.click();


        WebElement radioWithClass = driver.findElement(By.xpath("//input[@value='Nope']"));

        Thread.sleep(3000);
        radioWithClass.click();

        assert !radioId.isSelected();//Java Assertion

        assert radioWithClass.isSelected();



    }

}
