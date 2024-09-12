package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW01_Navigations {
    //Selenium Homework 01:
/*
    Create Chrome driver object
    Maximize the window
    Open LinkedIn home page https://www.linkedin.com/
    Navigate to YouTube home page https://www.youtube.com/
    Navigate back to LinkedIn
    Navigate forward to YouTube
    Refresh the page
    Close the browser
*/
    public static void main(String[] args) throws InterruptedException {

//        Create Chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open LinkedIn home page https://www.linkedin.com/
        Thread.sleep(2000);
        driver.get("https://linkedin.com/");

//        Navigate to YouTube home page https://www.youtube.com/
        Thread.sleep(2000);
        driver.get("https://youtube.com/");

//        Navigate back to LinkedIn
        Thread.sleep(2000);
        driver.navigate().back();

//        Navigate forward to YouTube
        Thread.sleep(2000);
        driver.navigate().forward();

//        Refresh the page
        Thread.sleep(2000);
        driver.navigate().refresh();

//        Close the browser
        Thread.sleep(2000);
        driver.close();

    }
}
