package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class miscellanous extends BaseConfig {

    @Test
    public void miscellanous() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElements(By.id("android:id/text1")).get(2).click();
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

        // Verificar si el teclado está visible antes de ocultarlo
//        if (driver.isKeyboardShown()) {
//            driver.hideKeyboard();  // Ocultar teclado solo si está visible
//            System.out.println("Teclado ocultado.");
//        } else {
//            System.out.println("El teclado ya estaba oculto.");
//        }

        // driver.hideKeyboard(); Si el emulador o dispositivo fisico muestra el teclado

        driver.findElement(AppiumBy.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(3000);
    }

}
