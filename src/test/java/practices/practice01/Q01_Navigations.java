package practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Q01_Navigations {
/*
    Create chrome driver object
    Maximize the window
    Open Google home page https://www.google.com/
    Navigate to TalentifyLab home page https://www.talentifylab.com/
    Navigate back to Google
    Navigate forward to TalentifyLab
    Refresh the page
    Close/Quit the browser
    And last step: print "ALL OK" on console
*/

    public static void main(String[] args) throws InterruptedException {
//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open Google home page https://www.google.com/
        driver.get("https://google.com");

//        Navigate to TalentifyLab home page
        driver.get("https://talentifylab.com/");

//        Navigate back to Google
        Thread.sleep(2000);
        driver.navigate().back();

//        Navigate forward to TalentifyLab
        Thread.sleep(2000);
        driver.navigate().forward();

//        Refresh the page
        Thread.sleep(2000);
        driver.navigate().refresh();

//        Close/Quit the browser
        Thread.sleep(2000);
        driver.close();

//        And last step: print "ALL OK" on console
        System.out.println("ALL OK");

    }


}
