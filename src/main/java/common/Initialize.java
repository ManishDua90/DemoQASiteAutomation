package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static common.BaseFixture.getElementProperties;
import static common.BaseFixture.getWebDriverProperties;
import static common.BaseFixture.maximizeWindow;

public class Initialize extends BaseFixture{

    final static Logger logger = Logger.getLogger(Initialize.class);
    private static WebDriver webDriver;
    private Properties webDriverProperties,elementProperties;
    public Initialize()
    {
        webDriver = Initialize.getWebDriver();
        webDriverProperties  = getWebDriverProperties();
        elementProperties = getElementProperties();
        //webDriver.get(elementProperties.get("demoQAURL").toString());
    }


   public void setOpenDemoURL(String dummy)
    {
        if (webDriverProperties.get("driver").toString().equalsIgnoreCase("chrome")) {
            logger.info("Found webdriver [" + webDriverProperties.get("driver") + "]. Launching chrome browser");

            webDriver = new ChromeDriver();
        }
        else if (webDriverProperties.get("driver").toString().equalsIgnoreCase("firefox")) {
            logger.info("Found webdriver [" + webDriverProperties.get("driver") + "]. Launching firefox browser");

            webDriver = new FirefoxDriver();
        }
        logger.info("Launching demoQA website");

        webDriver.get(elementProperties.get("demoQAURL").toString());
        maximizeWindow(webDriver);
    }
    public static WebDriver getWebDriver()
    {
        return webDriver;
    }
}
