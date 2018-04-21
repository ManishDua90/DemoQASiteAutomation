package fixtures;

import common.Initialize;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.DragAndDropPageObject;
import pageobjects.ResizablePageObject;

import javax.swing.*;
import java.util.Properties;

import static common.BaseFixture.getElementProperties;

public class ResizeItem {
    private Properties elementProperties;
    final static Logger logger = Logger.getLogger(ResizeItem.class);
    private WebDriver webDriver;
    private int flag = 0;
    public ResizeItem()
    {
        webDriver = Initialize.getWebDriver();
        elementProperties = getElementProperties();
    }
    public void setOpenResizable(String dummy)
    {
        ResizablePageObject.resizableLink(webDriver).click();
        logger.info("Opened Resizable page");
    }

    public void setResize(String size)
    {
        int x,y;
        String temp[] = size.split(",");
        x = Integer.parseInt(temp[0]);
        y = Integer.parseInt(temp[1]);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        WebElement w = ResizablePageObject.resizableBox(webDriver);
        String script = "arguments[0].setAttribute('style', 'WIDTH:"+x+"px;HEIGHT:"+y+"px')";
        js.executeScript(script,w);
      //  new Actions(webDriver).clickAndHold(ResizablePageObject.resizableBox(webDriver)).moveByOffset(x,y);
        flag = 1;
    }

    public boolean isResized()
    {
        if (flag==1)
            return true;
        else
            return false;
    }
}
