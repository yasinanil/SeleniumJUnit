package runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        practices.practice02.Q01_ActionsForm.class,
        practices.practice01.Q02_TitleTest.class,
        practices.practice01.Q03_BeforeAfterAnnotations.class,
        practices.practice01.Q04_FindElements.class


})

public class SmokeTestRunner {


}
