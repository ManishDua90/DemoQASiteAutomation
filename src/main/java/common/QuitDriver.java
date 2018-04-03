package common;

public class QuitDriver extends Initialize{
    public QuitDriver()
    {

        logger.info("Quitting webdriver");
        webDriver.quit();
    }
}
