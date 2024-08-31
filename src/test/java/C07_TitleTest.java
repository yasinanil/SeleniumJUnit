import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C07_TitleTest {

    WebDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void titleTest() {

        driver.get("https://talentifylab.com");

        String title = driver.getTitle();

        assertEquals("Talentify Web", title);

    }

    @Test
    public void urlTest() {

        driver.get("https://talentifylab.com");

        String url = driver.getCurrentUrl();

        assertEquals("https://talentifylab.com/en", url);

    }

}
