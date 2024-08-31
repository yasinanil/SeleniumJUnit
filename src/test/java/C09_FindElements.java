import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C09_FindElements {

    WebDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01(){

        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        List<WebElement> paragraphs =  driver.findElements(By.className("normal"));
        System.out.println(paragraphs.size());

        for (WebElement eachElement : paragraphs){
            System.out.println(eachElement.getText());
        }

    }

}
