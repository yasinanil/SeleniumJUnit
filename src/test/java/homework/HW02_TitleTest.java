package homework;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertTrue;

public class HW02_TitleTest {
/*
     Create chrome driver object
     Maximize the window
     Go to the "https://facebook.com/"
     Get the title and URL of the page
     Check if the title contains the word "Facebook"
     Check if the URL contains the word "facebook"
     Then go to "https://talentifylab.com/"
     Get the title and check if it contains the word "Talentify"
     Navigate Back to the previous webpage
     Refresh the page
     Navigate to forward
     Wait for 3 seconds
     Close the browser
*/

    @Test
    public void titleTest() throws InterruptedException {

//        Create chrome driver object
        WebDriver driver = new EdgeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Go to the "https://facebook.com/"
        driver.get("https://facebook.com/");

//        Get the title and URL of the page
        String title =driver.getTitle();
        String url =driver.getCurrentUrl();

//        Check if the title contains the word "Facebook"
        assertTrue(title.contains("Facebook"));

//        Check if the URL contains the word "facebook"
        assertTrue(url.contains("facebook"));

//        Then go to "https://talentifylab.com/"
        Thread.sleep(3000);
        driver.get("https://talentifylab.com/");

//        Get the title and check if it contains the word "Talentify"
        assertTrue(driver.getTitle().contains("Talentify"));

//        Navigate Back to the previous webpage
        Thread.sleep(3000);
        driver.navigate().back();

//        Refresh the page
        Thread.sleep(3000);
        driver.navigate().refresh();

//        Navigate to forward
        Thread.sleep(3000);
        driver.navigate().forward();

//        Wait for 3 seconds
        Thread.sleep(3000);
//        Close the browser
        driver.close();

    }
}
