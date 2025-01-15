package pageObjects.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.android.utils.Utils;

import java.util.Objects;

public class FormPage extends Utils {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

//    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
////    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
//    public WebElement femaleOption;

//    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
//    public WebElement maleOption;

    public void setCountrySelector(String country) {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollAndClickUtil(driver, country);
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setGenderFemale() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
    }

    public void setBntLetsShop() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

}
