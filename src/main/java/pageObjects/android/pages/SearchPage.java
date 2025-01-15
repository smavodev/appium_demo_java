package pageObjects.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.List;

public class SearchPage {

    AndroidDriver driver;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(AppiumBy.id("com.falabella.falabellaApp:id/tv_search"));
    }

    public WebElement getSearchResult() {
        return driver.findElement(AppiumBy.id("com.falabella.falabellaApp:id/search"));
    }

    public WebElement getSearchResultList(int index) {
        return driver.findElements(AppiumBy.id("com.falabella.falabellaApp:id/search_record_label")).get(index);
    }

    public void searchBox() {
        if(getSearchBox().isEnabled()) {
            getSearchBox().click();
        }
    }

    public void searchResult(String text) {
        if (getSearchResult().isEnabled()) {
            getSearchResult().sendKeys(text);
        }
    }

    /**
     * Selecciona el índice de búsqueda.
     * 0 = primer elemento,
     * 1 = segundo elemento
     * @see getSearchResultList(int index)
     */
    public void clickSearchResult(int index) {
        getSearchResultList(index).click();
    }

}
