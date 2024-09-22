import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C34_ChromeOptions {

    @Test
    public void chromeOptionsTest() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        //options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://linkedin.com");

        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        driver.close();

    }


}
