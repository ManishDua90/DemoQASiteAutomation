package common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Initialize {
    private static Properties elementProperties ;
    private static Properties webDriverProperties ;
    public static WebDriver webDriver;
    public Initialize()
    {
        setupBrowserConfig();
        loadElementProperties();
        //webDriver.get(elementProperties.get("demoQAURL").toString());

    }

    public static void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    private void loadElementProperties() {
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
    }

    private void setupBrowserConfig() {
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


    }


   /* public static WebDriver getWebDriver()
    {
        return webDriver;
    }*/

   public void setOpenDemoURL(String dummy)
    {
        if (webDriverProperties.get("driver").toString().equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        }
        else if (webDriverProperties.get("driver").toString().equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        }
        webDriver.get(elementProperties.get("demoQAURL").toString());
        maximizeWindow();
    }
    public static Properties getElementProperties() {
        return elementProperties;
    }
}
