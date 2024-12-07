package runners;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseConfig {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
//        cap.setCapability("deviceName", "Xiaomi M2101K6G"); // Pixel 8 API 33
//        cap.setCapability("udid", "3390e60e"); // emulator-5554
        cap.setCapability("deviceName", "Pixel 8 API 33");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("avd", "Pixel_8");  // Inicia el simulador android de manera automatica
        cap.setCapability("avdLaunchTimeout", 180000); // Tiempo de espera de lanzamiento del simulador en automatico
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "General-Store.apk";
        cap.setCapability("app", appUrl);
        // cap.setCapability("appPackage", "pe.sura.afpintegraapp");
        // cap.setCapability("appActivity", "pe.sura.afpintegraapp.MainActivity");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, cap);

        // Configuracion de espera global implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Application Started ......");

    }

    public void longPressAcction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
        ));
    }

    // Método reutilizable para hacer scroll hasta un elemento y hacer clic en él
    public static String scrollAndClick(WebDriver driver, String elementText) {
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

    // Método reutilizable para hacer scroll hasta un elemento y hacer clic en él por id, xpath, text
    public static void scrollAndClickAll(WebDriver driver, String locatorType, String locatorValue) {
        boolean canScrollMore = true;

        // Desplazamiento hasta que el elemento se encuentre
        while (canScrollMore) {
            try {
                WebElement element = null;

                // Usar el tipo de localizador adecuado
                switch (locatorType.toLowerCase()) {
                    case "text":
                        element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + locatorValue + "\"))"));
                        break;
                    case "id":
                        element = driver.findElement(AppiumBy.id(locatorValue));
                        break;
//                    case "accessid":
//                        element = driver.findElement(AppiumBy.accessibilityId(locatorValue));
//                        break;
                    case "xpath":
                        element = driver.findElement(AppiumBy.xpath(locatorValue));
                        break;
                    // Agregar más casos según sea necesario
                    default:
                        System.out.println("Tipo de localizador no soportado.");
                        return;
                }

                // Si el elemento está visible, hacer clic y salir del bucle
                if (element.isDisplayed()) {
                    element.click();
                    System.out.println("Elemento encontrado y clickeado: " + locatorValue);
                    break;
                }
            } catch (Exception e) {
                // Si no se encontró el elemento, realizar scroll hacia abajo
                canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 1200,
                        "direction", "down",
                        "percent", 1.0
                ));
            }
        }

        // Si no se encontró el elemento después de realizar el scroll
        if (!canScrollMore) {
            System.out.println("No se encontró el elemento con el localizador: " + locatorValue);
        }
    }

    public void swipeAction(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75, "speed", 2000
        ));
    }

    public void dragAndDrop(WebElement element, Number direction_x, Number direction_y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", direction_x,
                "endY", direction_y,
                "speed", 1000
        ));
    }

    public Double getFormatAmount(String amount){
        Double price =  Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

}
