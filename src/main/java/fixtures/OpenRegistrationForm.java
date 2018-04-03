package fixtures;


import common.ElementOperations;
import common.Initialize;
import helperservices.FillRegistrationFormHelperService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.RegistrationFormPageObject;

import java.util.Map;
import java.util.Properties;

public class
OpenRegistrationForm extends Initialize {
   // private WebDriver webDriver;
    private Properties elementProperties;
    final static Logger logger = Logger.getLogger(OpenRegistrationForm.class);

    ElementOperations elementOperations = new ElementOperations();
        public OpenRegistrationForm()
        {
            elementProperties = Initialize.getElementProperties();
        }
        public void setOpenForm(String dummy){
            //webDriver.get(elementProperties.getProperty("demoQARegistrationURL").toString());
            RegistrationFormPageObject.registrationButton(webDriver).click();
            logger.info("Opened Registration form");
        }

    public void setFillForm(Map<String,String> formData)
    {
        FillRegistrationFormHelperService.fillForm(formData);
        logger.info("Filled Registration form");
    }

    public boolean isFormOpened() {
        return RegistrationFormPageObject.registrationFormText(webDriver).isDisplayed();
    }
    public String getRegistrationStatus()
    {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        webDriverWait.until(ExpectedConditions.visibilityOf(RegistrationFormPageObject.registrationCompleteText(webDriver)));
        return RegistrationFormPageObject.registrationCompleteText(webDriver).getText().toString();
    }
}
