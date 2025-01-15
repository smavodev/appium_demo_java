package runners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseConfigBrowser {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
//        DesiredCapabilities cap = new DesiredCapabilities();
        UiAutomator2Options options = new UiAutomator2Options();

        // OPCION 1 - Driver Local
        // options.setChromedriverExecutable("C:\\Users\\Smavodev\\Desktop\\Proyectos_Testing\\appium_demo_java\\src\\main\\resources\\chromedriver.exe");

        // OPCION 2 + EJECUCION APPIUM
        options.setCapability("chromedriverAutodownload", true);  // appium server --allow-insecure chromedriver_autodownload

        options.setCapability("browserName", "Chrome");  // Configurando Navegador a usar

        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("platformName", "Android");
        options.setCapability("platformVersion", "12");
//        options.setCapability("deviceName", "Xiaomi M2101K6G"); // Pixel 8 API 33
//        options.setCapability("udid", "3390e60e"); // emulator-5554
        options.setCapability("deviceName", "Pixel 8 API 33");
        options.setCapability("udid", "emulator-5554");
        options.setCapability("avd", "Pixel_8");  // Inicia el simulador android de manera automatica
        options.setCapability("avdLaunchTimeout", 180000); // Tiempo de espera de lanzamiento del simulador en automatico


        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, options);

        // Configuracion de espera global implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Application Started ......");

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
