package helperservices;

import common.Initialize;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import pageobjects.RegistrationFormPageObject;

import java.util.Map;

public class FillRegistrationFormHelperService extends Initialize{
    final static Logger logger = Logger.getLogger(FillRegistrationFormHelperService.class);
    public static void fillForm(Map<String, String> formData) {
        logger.info("Filling Registration form");
        RegistrationFormPageObject.firstname(webDriver).sendKeys(formData.get("firstName"));
        RegistrationFormPageObject.lastName(webDriver).sendKeys(formData.get("lastName"));

        if (formData.get("maritalStatus").equalsIgnoreCase("Single"))
            RegistrationFormPageObject.maritalStatus(webDriver).get(0).click();
        else if (formData.get("maritalStatus").equalsIgnoreCase("Married"))
            RegistrationFormPageObject.maritalStatus(webDriver).get(1).click();
        else if (formData.get("maritalStatus").equalsIgnoreCase("Divorced"))
            RegistrationFormPageObject.maritalStatus(webDriver).get(2).click();

        if (formData.get("hobby").equalsIgnoreCase("Dance"))
            RegistrationFormPageObject.hobby(webDriver).get(0).click();
        else if (formData.get("hobby").equalsIgnoreCase("Reading"))
            RegistrationFormPageObject.hobby(webDriver).get(1).click();
        else if (formData.get("hobby").equalsIgnoreCase("Cricket"))
            RegistrationFormPageObject.hobby(webDriver).get(2).click();

        Select countryDropDown = new Select(RegistrationFormPageObject.countryDropDown(webDriver));
        countryDropDown.selectByValue(formData.get("country"));

        String dob[] = formData.get("dob").split("-");
        Select dateDropDown = new Select(RegistrationFormPageObject.dobDate(webDriver));
        dateDropDown.selectByValue(dob[0]);
        Select monthDropDown = new Select(RegistrationFormPageObject.dobMonth(webDriver));
        monthDropDown.selectByValue(dob[1]);
        Select yearDropDown = new Select(RegistrationFormPageObject.dobYear(webDriver));
        yearDropDown.selectByValue(dob[2]);

        RegistrationFormPageObject.phoneNumber(webDriver).sendKeys(formData.get("phoneNumber"));
        RegistrationFormPageObject.userName(webDriver).sendKeys(formData.get("userName"));
        RegistrationFormPageObject.emailId(webDriver).sendKeys(formData.get("emailId"));
        //RegistrationFormPageObject.profilePic(webDriver).sendKeys(formData.get("profilePic"));
        RegistrationFormPageObject.aboutYourself(webDriver).sendKeys(formData.get("aboutYourself"));
        RegistrationFormPageObject.password(webDriver).sendKeys(formData.get("password"));
        RegistrationFormPageObject.confirmPassword(webDriver).sendKeys(formData.get("confirmPassword"));
        RegistrationFormPageObject.submitFormButton(webDriver).click();


    }
}
