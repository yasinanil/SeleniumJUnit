import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C08_Locators {

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
    public void test01() throws InterruptedException {


        driver.get("https://testpages.eviltester.com/styled/index.html");

        WebElement basicpagetest = driver.findElement(By.id("basicpagetest"));
        Thread.sleep(3000);

        basicpagetest.click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement findbytest = driver.findElement(By.id("findbytest"));

        findbytest.click();
        Thread.sleep(2000);

        WebElement p5 = driver.findElement(By.name("pName5"));
        System.out.println("p5 = " + p5.getText());

        WebElement explanation = driver.findElement(By.className("explanation"));
        System.out.println("explanation = " + explanation.getText());

        String h1Text = driver.findElement(By.tagName("h1")).getText();

        System.out.println("h1Text = " + h1Text);

        WebElement index = driver.findElement(By.linkText("Index"));

        index.click();
        Thread.sleep(2000);

        WebElement secondLink = driver.findElement(By.partialLinkText("ent Attribu"));
        secondLink.click();

        String header = driver.findElement(By.tagName("h1")).getText();

        assertEquals("Element Attributes Examples", header);


    }

}
