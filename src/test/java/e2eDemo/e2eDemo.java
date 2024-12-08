package e2eDemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfigDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class e2eDemo extends BaseConfigDriver {

    @Test
    public void e2eComplete() throws InterruptedException {

        // Inicio de session
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        String country = scrollAndClick(driver,"Argentina");
        Assert.assertEquals(country, "Argentina");

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Elena");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        // Agregar productos al carrito de compras
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(1000);

        // Validación de sumatoria de precios de página Cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(
                AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalsum = 0;
        for (int i = 0; i < count; i++) {
            String amountPrices = productPrices.get(i).getText();
            // Double price =  Double.parseDouble(amountPrices.substring(1));
            Double price = getFormatAmount(amountPrices);
            totalsum = totalsum + price;
            // System.out.println("Price :" +  price);
            System.out.printf("Suma de %d: %.2f%n", i, price);
        }
        System.out.println("Total Sum: " + totalsum);

        String displaySum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFortmattedSum = getFormatAmount(displaySum);
        Assert.assertEquals(totalsum, displayFortmattedSum);

        WebElement element = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
        longPressAcction(element);
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();

        // Obtener los contextos actuales
        Thread.sleep(6000);
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println(context);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore"); // Manejo de contextos Nativo a Híbrido
        driver.findElement(By.name("q")).sendKeys("Smavodev");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP"); // Manejo de contextos Híbrido a Nativo
        Thread.sleep(3000);

    }

}
