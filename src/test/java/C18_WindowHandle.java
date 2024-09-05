import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C18_WindowHandle extends TestBase {


    @Test
    public void windowHandleTest() throws InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/windows-test.html");

        String p1Handle = driver.getWindowHandle();

        driver.findElement(By.id("gobasicajax")).click();

        Set<String> allHandles = driver.getWindowHandles();

        //1st Way:
//        for (String w : allHandles) {
//            if (!w.equals(p1Handle)){
//                driver.switchTo().window(w);
//            }
//        }

        //2nd Way:
        List<String> handleslist = new ArrayList<>(allHandles);
        driver.switchTo().window(handleslist.get(1));

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Code In It']")).click();

        driver.switchTo().newWindow(WindowType.TAB).get("https://google.com");
        String googlePage = driver.getWindowHandle();
        System.out.println(driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://linkedin.com");
        String linkedInPage = driver.getWindowHandle();
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        driver.switchTo().window(googlePage);
        Thread.sleep(3000);
        driver.switchTo().window(linkedInPage);

        Thread.sleep(3000);
        driver.switchTo().window(p1Handle);


    }

}
