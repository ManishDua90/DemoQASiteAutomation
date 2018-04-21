package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseFixture {
    final static Logger logger = Logger.getLogger(BaseFixture.class);
    private static Properties elementProperties ;
    private static Properties webDriverProperties ;
    private static WebDriver webDriver;
    public BaseFixture(){

        setupBrowserConfig();
        loadElementProperties();
    }
    private void loadElementProperties() {
        logger.info("Started loading element properties");
        InputStream is = null;
        elementProperties = new Properties();
        try {
            is = this.getClass().getResourceAsStream("/elementmapping.properties");
            elementProperties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Loaded element properties");

    }

    private void setupBrowserConfig() {
        logger.info("Started loading webdriver properties");

        InputStream is = null;
        webDriverProperties = new Properties();
        try {
            is = this.getClass().getResourceAsStream("/webdriver.properties");
            webDriverProperties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(webDriverProperties.get("driverSystemProperty").toString(), webDriverProperties.getProperty("driverpath").toString());
        logger.info("Loaded webdriver properties");
    }

    public static void maximizeWindow(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    public static Properties getElementProperties() {
        return elementProperties;
    }

    public static Properties getWebDriverProperties() {
        return webDriverProperties;
    }



}
