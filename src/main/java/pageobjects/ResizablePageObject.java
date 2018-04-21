package pageobjects;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResizablePageObject {
    private static WebElement element;
    public static WebElement resizableLink(@NotNull WebDriver driver){
        element = driver.findElement(By.linkText("Resizable"));
        return element;
    }

    public static WebElement resizableBox(@NotNull WebDriver driver){
        element = driver.findElement(By.cssSelector("#resizable > h3"));
        return element;
    }
}
