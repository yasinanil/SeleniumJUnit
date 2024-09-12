import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C22_File extends TestBase {

    @Test
    public void testTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("test1.jpeg")).click();

        Thread.sleep(200);

        assert Files.exists(Path.of(System.getProperty("user.home") + "\\Downloads\\test1.jpeg"));

    }


    @Test
    public void uploadTest() {

        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        String filePath = System.getProperty("user.home") + "/Desktop/flower.png";

        driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(filePath);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String fileName = driver.findElement(By.id("_valuefilename")).getText();

        assert filePath.contains(fileName);

    }

    @Test
    public void userDirTest() {

        // assert  Files.exists(Path.of("C:\\Users\\Talentify\\IdeaProjects\\MavenSeleniumProject\\myFile.txt"));

        assert Files.exists(Path.of(System.getProperty("user.dir") + "\\myFile.txt"));


    }

}
