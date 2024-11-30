package pageObjects.android.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public class PrincipalPage {

    AndroidDriver driver;

    public PrincipalPage(AndroidDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

//    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.falabella.falabellaApp:id/tv_not_now\"]")
//    public WebElement getNotNow_1;

    // Métodos para interactuar con los elementos usando findElement
    public WebElement getNotNow2() {
//        return driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.falabella.falabellaApp:id/tv_not_now\"]"));
        return driver.findElement(AppiumBy.id("com.falabella.falabellaApp:id/tv_not_now"));
    }

    public WebElement CountrySelect(int index) {
        // return driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id=\"com.falabella.falabellaApp:id/listViewCountryPicker\"]/android.widget.RelativeLayout[3]"));
        // return driver.findElement(AppiumBy.xpath("//android.widget.RelativeLayout[3]"));
        return driver.findElement(AppiumBy.xpath("//android.widget.RelativeLayout[" + index + "]"));
    }

//    public void clickNotNow1() {
//        getNotNow_1.click();
//    }

    public void clickNotNow2() {
        getNotNow2().click();
    }

    /**
     * Selecciona la posicion del pais.
     * 1 = Chile,
     * 2 = Colombia,
     * 3 = Peru
     * @see CountrySelect(int index)
     */
    public void clickCountrySelect(int index) {
        CountrySelect(index).click();
    }

}
