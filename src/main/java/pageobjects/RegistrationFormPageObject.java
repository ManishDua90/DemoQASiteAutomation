package pageobjects;

import com.sun.istack.internal.NotNull;
import common.BaseFixture;
import common.Initialize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationFormPageObject extends BaseFixture{

    private static WebElement element = null;
    private static List<WebElement> elements = null;
    public static WebElement registrationButton(@NotNull WebDriver driver){
        element = driver.findElement(By.linkText("Registration"));
        return element;
        }

    public static WebElement registrationFormText(@NotNull WebDriver driver){
        element = driver.findElement(By.className("entry-title"));
        return element;
    }

    public static WebElement firstname(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id='name_3_firstname']"));
        return element;
    }

    public static WebElement lastName(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id='name_3_lastname']"));
        return element;
    }

    public static List<WebElement> maritalStatus(@NotNull WebDriver driver){
        elements = driver.findElements(By.xpath("//*[@class='input_fields  radio_fields']"));
        for (WebElement u : elements)
            System.out.println(u.getText());
        return elements;
    }

    public static List<WebElement> hobby(@NotNull WebDriver driver){
        elements = driver.findElements(By.xpath("//*[@class=\"input_fields  piereg_validate[required] radio_fields\"]"));
        return elements;
    }

    public static WebElement countryDropDown(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]"));
        return element;
    }

    public static WebElement dobMonth(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"mm_date_8\"]"));
        return element;
    }

    public static WebElement dobDate(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"dd_date_8\"]"));
        return element;
    }

    public static WebElement dobYear(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"yy_date_8\"]"));
        return element;
    }

    public static WebElement phoneNumber(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"phone_9\"]"));
        return element;
    }

    public static WebElement userName(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        return element;
    }

    public static WebElement profilePic(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"profile_pic_10\"]"));
        return element;
    }

    public static WebElement emailId(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"email_1\"]"));
        return element;
    }

    public static WebElement aboutYourself(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"description\"]"));
        return element;
    }

    public static WebElement password(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"password_2\"]"));
        return element;
    }

    public static WebElement confirmPassword(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"confirm_password_password_2\"]"));
        return element;
    }

    public static WebElement submitFormButton(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[14]/div/input"));
        return element;
    }

    public static WebElement registrationCompleteText(@NotNull WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p"));
        return element;
    }















}
