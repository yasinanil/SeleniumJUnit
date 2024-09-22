import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import utilities.TestBase;

public class C32_Log4j {

    @Test
    public void log4jTest() {

        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C32_Log4j.class);

        logger.trace("This is trace level log");
        logger.debug("This is trace debug log");
        logger.info("This is info level log");
        logger.warn("This is warn level log");
        logger.error("This is error level log");
        logger.fatal("This is fatal level log");

    }

}
