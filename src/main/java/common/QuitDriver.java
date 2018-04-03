package common;

import org.openqa.selenium.WebDriver;

public class QuitDriver extends Initialize{
    public QuitDriver()
    {
        WebDriver webDriver = Initialize.getWebDriver();
        logger.info("Quitting webdriver");
        webDriver.quit();
    }
}
