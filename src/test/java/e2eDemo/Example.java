package e2eDemo;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class Example extends BaseConfig {

    private void completeForm(String name, boolean selectGenderFemale) {
        // Seleccionar el país
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        String country = scrollAndClick(driver, "Argentina");
        Assert.assertEquals(country, "Argentina");

        // Introducir nombre si se especifica
        if (name != null) {
            driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
        }

        // Seleccionar género
        if (selectGenderFemale) {
            driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        } else {
            driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
        }

        // Hacer clic en el botón "Let's Shop"
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

    @Test
    public void Principal() throws InterruptedException {
        completeForm("Elena", true);
        Thread.sleep(3000);
    }

    @Test
    public void errorMessageValid() {
        completeForm(null, true);
        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}
