package e2eDemo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

import java.time.Duration;

public class Demo extends BaseConfig {

    @Test
    public void Principal() throws InterruptedException {

        // Inicio de session
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        String country = scrollAndClick(driver,"Argentina");
        Assert.assertEquals(country, "Argentina");

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Elena");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        Thread.sleep(3000);

        // Seleccionar un producto en específico
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        String productSelect = scrollAndClick(driver,"PG 3");
        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase(productSelect)) {
                driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        // Validacion de carga de página Cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(
                AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        String lastPageProduct = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "PG 3");

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
        System.out.println(toastMessage);
    }

}
