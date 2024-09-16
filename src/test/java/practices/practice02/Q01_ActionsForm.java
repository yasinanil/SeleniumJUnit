package practices.practice02;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q01_ActionsForm extends TestBase {

/*
    1.	Open the website URL: https://yasinanil67.github.io/ActionsForm.
    2.	Enter a valid name, age, department, interests and gender(using Faker for randomization).
    3.	Click the "Generate Passcode" button.
    4.	Retrieve the generated passcode from the alert popup, extract the numeric value, and accept the alert.
    5.	In the next alert, enter the passcode and accept it.
    6.	Switch to the embedded form frame and click the "Submit" button.
    7.	Switch to the newly opened window.
    8.	Perform the following actions in sequence:
        o	Drag the element with id drag1 to the drop target drop1.
        o	Right-click on the element with id showSuccessButton.
        o	Double-click the button with id doubleClickButton.
        o	Hover over the button with id hoverButton.
    9.	Verify that the success message with id info is displayed.
*/

    @Test
    public void actionsTest() throws InterruptedException {

//        1.	Open the website URL: https://yasinanil67.github.io/ActionsForm.
        driver.get("https://yasinanil67.github.io/ActionsForm");

//        2.	Enter a valid name, age, department, interests and gender(using Faker for randomization).
        driver.findElement(By.id("name")).sendKeys(Faker.instance().name().fullName());
        driver.findElement(By.id("age")).sendKeys(Faker.instance().number().numberBetween(18, 65)+"");
        WebElement departmentDD = driver.findElement(By.id("options"));
        Select select = new Select(departmentDD);
        select.selectByVisibleText("IT Department");

        WebElement codingCB = driver.findElement(By.xpath("//input[@value='coding']"));
        if (!codingCB.isSelected()){
            codingCB.click();
        }

        driver.findElement(By.xpath("//input[@value='male']")).click();

//        3.	Click the "Generate Passcode" button.
        driver.findElement(By.xpath("//*[.='Generate Passcode']")).click();

//        4.	Retrieve the generated passcode from the alert popup, extract the numeric value, and accept the alert.
        String accessCode = driver.switchTo().alert().getText().replaceAll("[^0-9]", "");
        driver.switchTo().alert().accept();

//        5.	In the next alert, enter the passcode and accept it.
        driver.switchTo().alert().sendKeys(accessCode);
        driver.switchTo().alert().accept();

//        6.	Switch to the embedded form frame and click the "Submit" button.
        driver.switchTo().frame(0);
        driver.findElement(By.id("submitButton")).click();

//        7.	Switch to the newly opened window.
        Set<String> wHandlesSet = driver.getWindowHandles();
        List<String> wHandlesList = new ArrayList<>(wHandlesSet);

        driver.switchTo().window(wHandlesList.get(1));

//        8.	Perform the following actions in sequence:
        WebElement drag1 = driver.findElement(By.id("drag1"));
        WebElement drop1 = driver.findElement(By.id("drop1"));
        WebElement rightClickButton = driver.findElement(By.id("showSuccessButton"));
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickButton"));
        WebElement hoverButton = driver.findElement(By.id("hoverButton"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(drag1, drop1)//        o	Drag the element with id drag1 to the drop target drop1.
                .contextClick(rightClickButton)//        o	Right-click on the element with id showSuccessButton.
                .doubleClick(doubleClickButton)//        o	Double-click the button with id doubleClickButton.
                .moveToElement(hoverButton)//        o	Hover over the button with id hoverButton.
                .perform();

        assert driver.findElement(By.id("dragSuccessMessage")).isDisplayed();
        assert driver.findElement(By.id("rightClickSuccessMessage")).isDisplayed();
        assert driver.findElement(By.id("doubleClickSuccessMessage")).isDisplayed();
        assert driver.findElement(By.id("hoverSuccessMessage")).isDisplayed();


//        9.	Verify that the success message with id info is displayed.
        assertTrue(driver.findElement(By.id("info")).isDisplayed());
        assertEquals("Selenium's Actions Class", driver.findElement(By.tagName("h2")).getText());

    }

}
