package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutorUtils {

    private WebDriver driver;

    // Constructor to initialize the WebDriver instance
    public JavaScriptExecutorUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Method to execute JavaScript code
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(script, args);
    }

    // Method to scroll to an element
    public void scrollToElement(WebDriver driver, String elementId) {
        String script = "document.getElementById(arguments[0]).scrollIntoView(true);";
        executeScript(script, elementId);
    }

    // Method to scroll to a specific position
    public void scrollToPosition(int x, int y) {
        String script = "window.scrollTo(arguments[0], arguments[1]);";
        executeScript(script, x, y);
    }

    // Method to highlight an element
    public void highlightElement(WebDriver driver, String xpath) {
        String script = "arguments[0].style.border='3px solid red';";
        Object element = driver.findElement(By.xpath(xpath));
        executeScript(script, element);
    }

    // Method to click an element using JavaScript
    public void clickElement(WebDriver driver, String elementId) {
        String script = "document.getElementById(arguments[0]).click();";
        executeScript(script, elementId);
    }
}
