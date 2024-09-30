package practices.practice04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ExcelUtilities;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Q01_AddRecordToWebTable extends TestBase {

    @Before
    public void before() {
        driver.get("https://yasinanil67.github.io/addRecordWebTable");
    }


    //Test Case 1: Page Load
    //Objective: Verify the table is populated with 3 unique random names, ages, and countries on page load.
    @Test
    public void tc01() {
//        Step 1: Open the web page.


//        Expected Result: The table is populated with 3 rows of unique names, random ages (between 18-60), and random countries (USA, UK, Canada, Australia, Germany).
        List<WebElement> nameList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        assertEquals(3, nameList.size());
        List<String> strNames = new ArrayList<>();
        for (WebElement w : nameList) {
            strNames.add(w.getText());
        }


        List<String> names = new ArrayList<>(Arrays.asList("John Doe", "Jane Smith", "Alex Johnson", "Emily Davis", "Michael Brown", "Sarah Wilson", "David Lee", "Laura Miller"));

        assert names.containsAll(strNames);
    }


    //Test Case 2: Add Record - Successful
    //Objective: Verify that a new record is successfully added when valid inputs are provided.
    @Test
    public void tc02() throws InterruptedException {

//        Step 1: Enter a unique name in the "Name" field.
        Thread.sleep(1000);
        String name = "Mary Star";
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys(name);

//        Step 2: Enter a valid number in the "Age" field.
        Thread.sleep(1000);
        String age = "45";
        WebElement ageInput = driver.findElement(By.id("ageInput"));
        ageInput.sendKeys(age);

//        Step 3: Select a country from the dropdown.
        Thread.sleep(1000);
        String country = "Germany";
        Select countrySelect = new Select(driver.findElement(By.id("countrySelect")));
        countrySelect.selectByVisibleText(country);

//        Step 4: Click the "Add Record" button.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

//        Expected Result: The new record (Name, Age, and Country) is successfully added to the table, and the form fields are cleared.
        String nameCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText();
        String ageCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[2]")).getText();
        String countryCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]")).getText();

        assertEquals(name, nameCell);
        assertEquals(age, ageCell);
        assertEquals(country, countryCell);

        assert nameInput.getAttribute("value").isEmpty();
        assert ageInput.getAttribute("value").isEmpty();
        String defaultOption = countrySelect.getFirstSelectedOption().getText();
        assertEquals("Select Country", defaultOption);

    }


    //Test Case 3: Add Record - Empty Fields
    //Objective: Verify that a record is not added when any of the fields are left blank.
    @Test
    public void tc03() throws InterruptedException {

//        Step 1: Leave one or more of the fields (Name, Age, or Country) blank.
        Thread.sleep(1000);
        String age = "45";
        WebElement ageInput = driver.findElement(By.id("ageInput"));
        ageInput.sendKeys(age);
        Thread.sleep(1000);
        String country = "Germany";
        Select countrySelect = new Select(driver.findElement(By.id("countrySelect")));
        countrySelect.selectByVisibleText(country);

//        Step 2: Click the "Add Record" button.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

//        Expected Result: An alert appears saying "Please fill out all fields.", and no new record is added.
        String text = driver.switchTo().alert().getText();
        System.out.println("text = " + text);

        assertEquals("Please fill out all fields.", text);

    }


    //Test Case 4: Add Record - Duplicate Name
    //Objective: Verify that a duplicate name cannot be added to the table.
    @Test
    public void tc04() throws InterruptedException {

//        Step 1: Add a record with a unique name.
//        Step 2: Try adding the same name again.
        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            String name = "Mary Star";
            WebElement nameInput = driver.findElement(By.id("nameInput"));
            nameInput.sendKeys(name);
            String age = "45";
            WebElement ageInput = driver.findElement(By.id("ageInput"));
            ageInput.sendKeys(age);
            String country = "Germany";
            Select countrySelect = new Select(driver.findElement(By.id("countrySelect")));
            countrySelect.selectByVisibleText(country);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[.='Add Record']")).click();
        }

//        Expected Result: An alert appears saying "This name already exists in the table.", and no duplicate record is added.
        String text = driver.switchTo().alert().getText();
        assertEquals("This name already exists in the table.", text);
    }

//    TC 01 covered this:
//    Test Case 5: Form Field Reset
//    Objective: Verify that the input fields are cleared after successfully adding a record.

    //    Test Case 6: Button Hover Effect
//    Objective: Verify that the button changes color when hovered.
    @Test
    public void tc06() throws InterruptedException {

        WebElement addRecordButton = driver.findElement(By.xpath("//*[.='Add Record']"));

        String bgColorBeforeHover = addRecordButton.getCssValue("background-color");
        System.out.println("bgColorBeforeHover = " + bgColorBeforeHover);

        new Actions(driver).moveToElement(addRecordButton).perform();

        String bgColorAfterHover = addRecordButton.getCssValue("background-color");
        System.out.println("bgColorAfterHover = " + bgColorAfterHover);

        assertNotEquals(bgColorBeforeHover, bgColorAfterHover);

    }

    //Test Case 7: Table Row Hover Effect
    //Objective: Verify that table rows change background color when hovered.
    @Test
    public void tc07() throws InterruptedException {

        WebElement anyRow = driver.findElement(By.xpath("//tbody/tr"));

        String bgColorBeforeHover = anyRow.getCssValue("background-color");
        System.out.println("bgColorBeforeHover = " + bgColorBeforeHover);

        new Actions(driver).moveToElement(anyRow).perform();

        String bgColorAfterHover = anyRow.getCssValue("background-color");
        System.out.println("bgColorAfterHover = " + bgColorAfterHover);

        assertNotEquals(bgColorBeforeHover, bgColorAfterHover);

    }


    //Add records from Excel file
    @Test
    public void excelTest() throws InterruptedException {

        ExcelUtilities excelUtilities = new ExcelUtilities("src/test/java/practices/practice04/Employees.xlsx", "Info");

//        Step 1: Enter a unique name in the "Name" field.

        for (int i = 1; i < excelUtilities.getRowCount(); i++) {

            String name = excelUtilities.getCellValue(i, 0);
            WebElement nameInput = driver.findElement(By.id("nameInput"));
            nameInput.sendKeys(name);

            String age = excelUtilities.getCellValue(i, 1);
            age = age.substring(0, age.indexOf("."));
            WebElement ageInput = driver.findElement(By.id("ageInput"));
            ageInput.sendKeys(age);

            String country = excelUtilities.getCellValue(i, 2);
            Select countrySelect = new Select(driver.findElement(By.id("countrySelect")));
            countrySelect.selectByVisibleText(country);

            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[.='Add Record']")).click();

//        Expected Result: The new record (Name, Age, and Country) is successfully added to the table, and the form fields are cleared.
            String nameCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText();
            String ageCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[2]")).getText();
            String countryCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[3]")).getText();

            assertEquals(name, nameCell);
            assertEquals(age, ageCell);
            assertEquals(country, countryCell);

        }

    }

}
