package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class DragandDrop extends BaseConfig {

    @Test
    public void DraganDrop() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

//        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) source).getId(),
//                "endX", 610, // 619
//                "endY", 965,   // 560
//                "speed", 1000
//        ));
        dragAndDrop(source, 610, 965);

        Thread.sleep(3000);
        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");
    }

}
