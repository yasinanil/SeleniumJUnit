package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {

    protected WebDriver driver;
    private static ExtentReports extent;
    protected ExtentTest test;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Create a test instance in the report
        test = extent.createTest(testName.getMethodName());

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public String takeFullPageScreenshot() {

        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        String path = System.getProperty("user.dir") + "/test-outputs/screenshots/fullPageScreenshot" + timestamp + ".png";

        File target = new File(path);

        try {
            Files.copy(ss.toPath(), target.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;

    }

    public String takeSpecificElementsScreenshot(WebElement element) {

        File ss = element.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        String path = System.getProperty("user.dir") + "/test-outputs/screenshots/elementsScreenshot" + timestamp + ".png";

        File target = new File(path);

        try {
            Files.copy(ss.toPath(), target.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;

    }

    public String passAndTakeScreenshot(String message) {

        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        String path = System.getProperty("user.dir") + "/test-outputs/screenshots/fullPageScreenshot" + timestamp + ".png";

        File target = new File(path);

        try {
            Files.copy(ss.toPath(), target.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        test.pass(message).addScreenCaptureFromPath(path);

        return path;

    }


    @BeforeClass
    public static void setup() throws IOException {
        // Initialize ExtentSparkReporter
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        ExtentSparkReporter spark = new ExtentSparkReporter("test-outputs/reports/ExtentReport_" + timestamp + ".html");
        spark.loadXMLConfig("extent-config.xml"); // Load the configuration file

        // Initialize ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Set system or environment information
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Company", "XYZ");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Team", "Our Boys");
    }

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void cleanup() {
        // Mark the test as complete
        extent.flush();
    }

}
