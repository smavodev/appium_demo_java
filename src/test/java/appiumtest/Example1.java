package appiumtest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

import java.net.MalformedURLException;

public class Example1 extends BaseConfig {

    @Test
    public void Example_1() throws MalformedURLException {
        // ConfigureAppium();
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElements(By.id("android:id/text1")).get(2).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Text de prueba");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        // TearDown();
    }

}
