package homework;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class HW11_AmazonDropDown extends TestBase {
    /*
        Go to https://amazon.com (Refresh the page once or more if you get captcha)
        Print all the options in the 'Departments' dropdown on the left side of the search box
        Search for each first five options and print titles
    */
    @Test
    public void test() {

//        Go to https://amazon.com
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

//        Print all the options in the 'Departments' dropdown on the left side of the search box
        WebElement searchDropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchDropDown);
        List<WebElement> options = select.getOptions();
//        for (WebElement w : options) {
//            System.out.println(w.getText());
//        }

        //Using Lambda is recommended
        options.forEach(t -> System.out.println(t.getText()));

//        Search for each first five options and print titles
        System.out.println("\nSearch for each first five options and print titles:");
        for (int i = 0; i < 5; i++) {
            String option = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions().get(i).getText();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(option, Keys.ENTER);
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }
}
