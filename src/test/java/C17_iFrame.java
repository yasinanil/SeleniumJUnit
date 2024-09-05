import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C17_iFrame extends TestBase {

    @Test
    public void iFrameTest() {

        driver.get("https://testpages.eviltester.com/styled/iframes-test.html");

        driver.switchTo().frame(0);

        String text1 = driver.findElement(By.id("iframe0")).getText();
        System.out.println("text1 = " + text1);

        driver.switchTo().parentFrame();

        String p = driver.findElement(By.tagName("p")).getText();
        System.out.println("p = " + p);


    }
}
