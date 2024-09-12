import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C20_Cookies extends TestBase {

    @Test
    public void cookiesTest(){

        driver.get("https://yasinanil67.github.io/Cookies");

        Cookie cookie1 = driver.manage().getCookieNamed("username");

        System.out.println("cookie1 = " + cookie1);


        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Number of cookies before adding new cookie: "+allCookies.size());


        Cookie newCookie = new Cookie("email","john@doe.com");

        driver.manage().addCookie(newCookie);

        System.out.println("Number of cookies after adding new cookie: "+driver.manage().getCookies().size());

        driver.manage().deleteCookie(newCookie);

        System.out.println("Number of cookies after deleting new cookie: "+driver.manage().getCookies().size());

        driver.manage().deleteAllCookies();

        System.out.println("Number of cookies after deleting all cookies: "+driver.manage().getCookies().size());


    }

}
