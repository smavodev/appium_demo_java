package pageObjects.android.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    // Metodo reutilizable para hacer scroll hasta un elemento y hacer clic en él
    public static String scrollAndClickUtil(WebDriver driver, String elementText) {
        boolean canScrollMore = true;

        // Desplazamiento hasta que el elemento se encuentre
        while (canScrollMore) {
            try {
                // Verificar si el elemento está visible
                WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
                if (element.isDisplayed()) {
                    // Si el elemento está visible, hacer clic
                    element.click();
                    System.out.println("Elemento encontrado y clickeado: " + elementText);
                    break;
                }
            } catch (Exception e) {
                // Si no se encontró, realizar scroll hacia abajo
                canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 600,
                        "direction", "down",
                        "percent", 0.90
                ));
            }
        }

        // Si no se encontró el elemento después de realizar el scroll
        if (!canScrollMore) {
            System.out.println("No se encontró el elemento con el texto: " + elementText);
        }
        return elementText;
    }


}
