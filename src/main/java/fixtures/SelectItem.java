package fixtures;

import common.BaseFixture;
import common.Initialize;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.DragAndDropPageObject;
import pageobjects.SelectPageObject;

import java.util.List;
import java.util.Properties;

public class SelectItem {
    private WebDriver webDriver;
    private Properties elementProperties;
    final static Logger logger = org.apache.log4j.Logger.getLogger(SelectItem.class);

    int flag = 0;
    public SelectItem()
    {
        webDriver = Initialize.getWebDriver();
        elementProperties = BaseFixture.getElementProperties();
    }

    public void setOpenSelectable(String dummy)
    {
        SelectPageObject.SelectableLink(webDriver).click();
        logger.info("Opened Selectable page");
    }

    public void setSelectAll(String dummy)
    {
        List<WebElement> list = SelectPageObject.getItemsToBeSelected(webDriver);
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).build().perform();
        for (WebElement webElement :list)
        {
            if (webElement.isDisplayed())
            webElement.click();
        }

        flag = 1;
    }

    public boolean isSelected()
    {
        if (flag==1)
            return true;
        else
            return false;
    }


}
