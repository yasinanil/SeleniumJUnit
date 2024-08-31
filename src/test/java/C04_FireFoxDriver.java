import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C04_FireFoxDriver {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://google.com");

        driver = new EdgeDriver();

        driver.get("https://linkedin.com");

        Thread.sleep(3000);

        driver.quit();

    }

}
