package common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class ElementOperations extends Initialize {
   // private WebDriver webDriver;
    private Properties elementProperties;
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public ElementOperations() {
     //   webDriver = Initialize.getWebDriver();
        elementProperties = Initialize.getElementProperties();
    }
    public void clickOnTheGivenElement(String name){
        waitForaGivenElement(elementProperties.getProperty(name));
        webDriver.findElement(By.cssSelector(elementProperties.getProperty(name))).click();
    }

    public void waitForaGivenElement(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(name)));
    }

    public void enterValueInanEdit(String name, String value){
        waitForaGivenElement(elementProperties.getProperty(name));
          webDriver.findElement(By.cssSelector(elementProperties.getProperty(name))).sendKeys(value);
    }

    public void clickOnMultipleElements(ArrayList<String> names)
    {
        for(String name : names){
            waitForaGivenElement(elementProperties.getProperty(name));
            webDriver.findElement(By.cssSelector(elementProperties.getProperty(name))).click();
        }
    }

    public void selectValue(String dropDownName,String value){
        waitForaGivenElement(elementProperties.getProperty(dropDownName));
       Select dropDown = new Select(webDriver.findElement(By.cssSelector(elementProperties.getProperty(dropDownName))));
       dropDown.selectByVisibleText(value);
    }

    public void enterMultipleValues(Map<String,String> values)
    {
        Iterator iterator = values.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry pair = (Map.Entry)iterator.next();
            waitForaGivenElement(elementProperties.getProperty(pair.getKey().toString()));
           webDriver.findElement(By.cssSelector(elementProperties.getProperty(pair.getKey().toString()))).sendKeys(pair.getValue().toString());
        }
    }

    public void enterMultipleDropDowwnValues(Map<String,String> values)
    {
        Iterator iterator = values.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry pair = (Map.Entry)iterator.next();
            waitForaGivenElement(elementProperties.getProperty(pair.getKey().toString()));
            Select dropDown = new Select(webDriver.findElement(By.cssSelector(elementProperties.getProperty(pair.getKey().toString()))));
            dropDown.selectByVisibleText(pair.getValue().toString());
        }
    }
}
