import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorUtils;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C31_JavascriptExecutor extends TestBase {

    @Test
    public void jsExecutorTest() throws InterruptedException {

        driver.get("https://talentifylab.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("(//h1)[2]"));

        js.executeScript("arguments[0].style.backgroundColor = 'red'", element);

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,3000)");

        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + title);

        WebElement contact = driver.findElement(By.xpath("//span[.='Contact']"));

        js.executeScript("arguments[0].click();", contact);

        Thread.sleep(500);
        assertEquals("https://talentifylab.com/en/contact", driver.getCurrentUrl());

    }

    @Test
    public void jsExecutorUtilsTest(){

        driver.get("https://talentifylab.com");

        JavaScriptExecutorUtils js = new JavaScriptExecutorUtils(driver);

        js.highlightElement(driver, "(//h1)[2]");

    }

}
