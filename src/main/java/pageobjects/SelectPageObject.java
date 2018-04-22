package pageobjects;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectPageObject {
    private static WebElement element;
    private static List<WebElement> list;
    public static WebElement SelectableLink(@NotNull WebDriver driver){
        element = driver.findElement(By.linkText("Selectable"));
        return element;
    }

    public static List<WebElement> getItemsToBeSelected(@NotNull WebDriver driver){
        list = driver.findElements(By.cssSelector("li.ui-widget-content.ui-corner-left.ui-selectee"));
        return list;
    }
    public static WebElement selectItem7(@NotNull WebDriver driver){
        element = driver.findElement(By.cssSelector("#selectable > li:nth-child(7)"));
        return element;
    }
}
