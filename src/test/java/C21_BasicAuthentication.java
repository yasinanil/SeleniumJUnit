import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C21_BasicAuthentication extends TestBase {

    @Test
    public void bAuthTest(){

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        assert driver.findElement(By.tagName("p")).getText().contains("Congratulations");

    }

}
