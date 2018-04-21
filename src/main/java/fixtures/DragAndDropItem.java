package fixtures;

import common.BaseFixture;
import common.Initialize;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageobjects.DragAndDropPageObject;

import java.util.Properties;

import static common.BaseFixture.getElementProperties;

public class DragAndDropItem extends BaseFixture {
    private Properties elementProperties;
    final static Logger logger = Logger.getLogger(DragAndDropItem.class);
    private WebDriver webDriver;
    private int flag = 0;
    public DragAndDropItem()
    {
        webDriver = Initialize.getWebDriver();
        elementProperties = getElementProperties();
    }

    public void setOpenDraggable(String dummy)
    {
        DragAndDropPageObject.DraggableLink(webDriver).click();
        logger.info("Opened Draggable page");
    }

    public void setDragToXY(String xyCoordinate)
    {
        int x,y;
        String temp[] = xyCoordinate.split(",");
        x = Integer.parseInt(temp[0]);
        y = Integer.parseInt(temp[1]);
        new Actions(webDriver).dragAndDropBy(DragAndDropPageObject.draggableBox(webDriver), x, y).build() .perform();
        flag = 1;
    }

    public boolean isDragged()
    {
        if (flag==1)
            return true;
        else
            return false;
    }

}
