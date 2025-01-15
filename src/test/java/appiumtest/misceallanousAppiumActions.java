package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class misceallanousAppiumActions extends BaseConfig {

    @Test
    public void misceallanousAppiumActions() throws InterruptedException {

        // OPCION 1
        // Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        // driver.startActivity(activity);

        // OPCION 2
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
                "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landScape = new DeviceRotation(0,0, 90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.setClipboardText("Smavodev wifi");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(3000);

        driver.findElement(AppiumBy.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(3000);
    }

}
