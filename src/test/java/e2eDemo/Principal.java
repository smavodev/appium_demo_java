package e2eDemo;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class Principal extends BaseConfig {

    @Test
    public void Principal() throws InterruptedException {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        String country = scrollAndClick(driver,"Argentina");
        Assert.assertEquals(country, "Argentina");

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Elena");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        Thread.sleep(3000);
    }

    @Test
    public void errorMessageValid() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        String country = scrollAndClick(driver,"Argentina");
        Assert.assertEquals(country, "Argentina");

        // driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Elena");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}
