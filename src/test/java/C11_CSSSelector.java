import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_CSSSelector {

    WebDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Dynamic wait

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void cssSelectorTest(){

        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        String text1 = driver.findElement(By.cssSelector("#p1")).getText();
        System.out.println("text1 = " + text1);

        String explanation = driver.findElement(By.cssSelector(".explanation")).getText();
        System.out.println("explanation = " + explanation);

        String p7 = driver.findElement(By.cssSelector("p[name='pName7']")).getText();
        System.out.println("p7 = " + p7);

    }

}
