import org.junit.*;
import utilities.TestBase;


public class C28_ExtentReport extends TestBase {


    @Test
    public void testPass() {
        // Log test information
        test.pass("This test passed successfully.");
    }

    @Test
    public void testFail() {
        // Log test information and mark it as failed
        test.fail("This test failed.");
    }

    @Test
    public void testSkip() {
        // Log test information
        test.skip("This test skipped.");
    }

    @Test
    public void testInfo() {
        // Log test information
        test.info("This is a test.");
    }

    @Test
    public void addScreenshotToReportTest(){

        test.info("Go to homepage");
        driver.get("https://linkedin.com");

        test.pass("User is on homepage");
        test.addScreenCaptureFromPath(takeFullPageScreenshot());

    }



}
