import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C33_Log4jTest extends TestBase {

    @Test
    public void formTest(){

        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C33_Log4jTest.class);

        logger.info("Going to homepage");

        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        String fullName = Faker.instance().name().fullName();

        driver.findElement(By.name("username")).sendKeys(fullName);

        logger.info("Username entered as "+fullName);

        String password = Faker.instance().internet().password();

        driver.findElement(By.name("password")).sendKeys(password);

        logger.info("Password entered as "+password);

        String comment = Faker.instance().lorem().paragraph();

        driver.findElement(By.name("comments")).clear();

        driver.findElement(By.name("comments")).sendKeys(comment);

        logger.info("Comment entered as "+comment);


    }

}
