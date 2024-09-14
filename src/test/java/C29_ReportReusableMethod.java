import org.junit.Test;
import utilities.TestBase;

public class C29_ReportReusableMethod extends TestBase {

    @Test
    public void test01(){

        driver.get("https://talentifylab.com");

        passAndTakeScreenshot("User is on homepage");


    }

}
