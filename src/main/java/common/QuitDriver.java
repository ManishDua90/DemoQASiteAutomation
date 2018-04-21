package common;

import fixtures.OpenRegistrationForm;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class QuitDriver {
    final static Logger logger = Logger.getLogger(QuitDriver.class);

    public QuitDriver() throws InterruptedException {
        Thread.sleep(3000);
        WebDriver webDriver = Initialize.getWebDriver();
        logger.info("Quitting webdriver");
        webDriver.quit();
    }
}
