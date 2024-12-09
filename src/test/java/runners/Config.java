package runners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Config {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configBase() throws MalformedURLException {
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
//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "General-Store.apk";
//        cap.setCapability("app", appUrl);
        cap.setCapability("appPackage", "com.falabella.falabellaApp");
        cap.setCapability("appActivity", "com.falabella.falabellaApp.SplashActivity");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, cap);

        // Configuracion de espera global implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Application Started ......");

    }

    public Double getFormatAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
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
