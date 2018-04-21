package pageobjects;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPageObject {
    private static WebElement element;
    public static WebElement DraggableLink(@NotNull WebDriver driver){
        element = driver.findElement(By.linkText("Draggable"));
        return element;
    }

    public static WebElement draggableBox(@NotNull WebDriver driver){
        element = driver.findElement(By.cssSelector("#draggable"));
        return element;
    }



}
