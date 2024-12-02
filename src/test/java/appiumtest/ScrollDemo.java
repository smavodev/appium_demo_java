package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class ScrollDemo extends BaseConfig {

    @Test
    public void ScrollDemo() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        // FORMA 1: Scroll con UIAutomator
        // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))")).click();
        scrollAndClick(driver, "Switches");


        // scrollAndClickAll(driver, "accessid", "Switches");

        // Forma 2: Scroll mobile: swipeGesture https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
//        boolean canScrollMore;
//        do {
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", 100, "top", 100, "width", 200, "height", 600,
//                    "direction", "down",
//                    "percent", 0.90
//            ));
//        } while(canScrollMore);
//
//         driver.findElement(AppiumBy.accessibilityId("Layouts")).click();

        // OPCIONAL A LA FORMA 2
//        boolean canScrollMore = false;
//
//        do {
//            // Verificar si el elemento está visible
//            if (!driver.findElements(AppiumBy.accessibilityId("WebView")).isEmpty()) {
//                // Si el elemento está visible, hacer clic y salir del bucle
//                driver.findElement(AppiumBy.accessibilityId("WebView")).click();
//                break;
//            }
//
//            // Realizar el gesto de desplazamiento
//            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left", 100, "top", 100, "width", 200, "height", 1200,
//                    "direction", "down",
//                    "percent", 1.0
//            ));
//        } while (canScrollMore); // Continuar desplazándose mientras sea posible
//
//         // Si no se encontró el elemento después del scroll
//        if (!canScrollMore) {
//            System.out.println("No se encontró el elemento después de recorrer toda la lista.");
//        }
//

        // Forma 3: Haciendo scroll a la lista en general
//        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
//
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", "up",
//                "percent", 0.25
//        ));
//
//        Thread.sleep(3000);
//
//

    }


}
