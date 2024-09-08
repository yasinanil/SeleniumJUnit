package practices.practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q02_TitleTest {
    /*
         Create chrome driver object
         Maximize the window
         Open google home page https://www.google.com/
         Wait for 3 seconds
         Go to the "https://www.linkedin.com/"
         Get the title and URL of the page
         Check if the title contains the word "LinkedIn" print console "Title contains LinkedIn" or "Title does not contain LinkedIn"
         Check if the URL contains the word "linkedin" print console "URL contains linkedin" or "URL does not contain linkedin"
         Then go to "https://www.google.com/"
         Get the title and check if it contains the word "Google" and print "Title contains Google" or "Title does not contain Google"
         Navigate Back to the previous webpage
         Refresh the page
         Navigate to forward
         Wait for 3 seconds
         Close the browser
    */
    @Test
    public void titleTest() throws InterruptedException {
//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.google.com/
        driver.get("https://google.com");

//        Wait for 3 seconds
        Thread.sleep(3000);

//        Go to the "https://www.linkedin.com/"
        driver.get("https://linkedin.com");

//        Get the title and URL of the page
        String linkedInTitle = driver.getTitle();

//        Check if the title contains the word "LinkedIn" print console "Title contains LinkedIn" or "Title does not contain LinkedIn"
        boolean isContain = linkedInTitle.contains("LinkedIn");

        assertTrue(isContain);

//        Check if the URL contains the word "linkedin" print console "URL contains linkedin" or "URL does not contain linkedin"
        String linkedInUrl = driver.getCurrentUrl();
        assertTrue(linkedInUrl.contains("linkedin"));

//        Then go to "https://google.com/"
        driver.navigate().to("https://google.com/");

//        Get the title and check if it contains the word "Google" and print "Title contains Google" or "Title does not contain Google"
        String googleTitle = driver.getTitle();
        assertTrue(googleTitle.contains("Google"));

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
//        Close the browser
        Thread.sleep(3000);
        driver.close();

    }
}
