import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethods {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://talentifylab.com");

        String title = driver.getTitle();

        System.out.println("title = " + title);

        String url = driver.getCurrentUrl();

        System.out.println("url = " + url);

        String pageSource = driver.getPageSource();

        System.out.println("pageSource = " + pageSource);

        String wHandle = driver.getWindowHandle();

        System.out.println("wHandle = " + wHandle);

        driver.quit();

    }
}
