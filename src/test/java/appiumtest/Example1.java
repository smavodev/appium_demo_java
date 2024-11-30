package appiumtest;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import runners.BaseConfig;

import java.net.MalformedURLException;

public class Example1 extends BaseConfig {

    @Test
    public void Example_1() throws MalformedURLException {
        // ConfigureAppium();
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        // TearDown();
    }

}
