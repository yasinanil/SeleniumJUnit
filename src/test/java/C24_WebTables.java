import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C24_WebTables extends TestBase {

    @Test
    public void webTablesTest(){

        driver.get("https://yasinanil.github.io/webTable");

        WebElement webTable = driver.findElement(By.xpath("(//table)[2]"));

        WebElement tr1 = webTable.findElement(By.xpath(".//tbody/tr[1]"));
        System.out.println("tr1= " + tr1.getText());

        List<WebElement> allRows = webTable.findElements(By.xpath(".//tbody/tr"));

        for (WebElement w: allRows){
            System.out.println(w.getText());
        }

        List<WebElement> r3AllCells = webTable.findElements(By.xpath(".//tbody/tr[3]/td"));

        for (WebElement w: r3AllCells){
            System.out.println(w.getText());
        }

        WebElement r7c3 = webTable.findElement(By.xpath(".//tr[7]/td[3]"));
        System.out.println("r7c3: " + r7c3.getText());

        List<WebElement> column3 = webTable.findElements(By.xpath(".//td[3]"));

        column3.forEach(t-> System.out.println(t.getText()));


    }

}
