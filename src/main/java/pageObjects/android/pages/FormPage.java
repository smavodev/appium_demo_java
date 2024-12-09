package pageObjects.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.android.utils.Utils;

public class FormPage extends Utils {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public WebElement femaleOption;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public WebElement maleOption;

    public void setCountrySelector(String country) {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollAndClickUtil(driver, country);
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female") && maleOption.isSelected()) {
            femaleOption.click();
        }
    }

    public void setBntLetsShop(){
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

}
