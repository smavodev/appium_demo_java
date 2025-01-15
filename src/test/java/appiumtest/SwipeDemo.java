package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class SwipeDemo extends BaseConfig {

    @Test
    public void SwipeDemo() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElements(AppiumBy.id("android:id/text1")).get(0).click();

        WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[1])"));
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[1])")).getAttribute("focusable"), "true");

//        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) firstImage).getId(),
//                "direction", "left",
//                "percent", 0.75, "speed", 2000
//        ));
        swipeAction(firstImage, "left");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[1])")).getAttribute("focusable"), "false");

    }

}
