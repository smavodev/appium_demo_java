package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class LongerPress extends BaseConfig {

    @Test
    public void longerPress() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
//        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
//        ));
        longPressAcction(element);
        String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");
        Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());

    }

}
