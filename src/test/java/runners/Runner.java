package runners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Runner {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {

        if (platformName == null || platformName.isEmpty()) {
            throw new IllegalArgumentException("El parámetro platformName no puede ser nulo o vacío.");
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", 300);

        URL url;
        try {
            url = new URL("http://0.0.0.0:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException("La URL del servidor Appium no es válida: " + e.getMessage(), e);
        }

        try {
            switch (platformName) {
                case "Android_fisico":
                    caps.setCapability("deviceName", "Xiaomi M2101K6G");
                    caps.setCapability("automationName", "UiAutomator2");
                    caps.setCapability("udid", "3390e60e");
//                    String app2Url = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"
//                            + File.separator + "ApiDemos-debug.apk";
                    caps.setCapability("appPackage", "com.falabella.falabellaApp");
                    caps.setCapability("appActivity", "com.falabella.falabellaApp.newHome.AppHomeActivity");
                    System.out.println("Conexion establecida");
                    return new AndroidDriver(url, caps);
                case "Android_emulador":
                    caps.setCapability("deviceName", "Pixel 8");
                    caps.setCapability("automationName", "UiAutomator2");
                    caps.setCapability("udid", "emulator-5554");
                    caps.setCapability("avd", "Pixel_8");  // Inicia el simulador android de manera automatica
                    caps.setCapability("avdLaunchTimeout", 180000); // Tiempo de espera de lanzamiento del simulador en automatico
                    // caps.setCapability("dontReset", true); // Evita que el emulador se restablezca y conserve el estado
//                    caps.setCapability("fullReset", false); // Evita que el dispositivo se reinicie completamente
//                    String app1Url = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"
//                            + File.separator + "ApiDemos-debug.apk";
                    caps.setCapability("appPackage", "com.falabella.falabellaApp");
                    caps.setCapability("appActivity", "com.falabella.falabellaApp.SplashActivity");
                    System.out.println("Conexion establecida");
                    return new AndroidDriver(url, caps);
                case "iOS":
                    caps.setCapability("deviceName", "iPhone 15 Pro Max");
                    caps.setCapability("automationName", "XCUITest");
                    caps.setCapability("udid", "90C2A674-E8E2-4CCF-98C9-13686AA26086");
                    String iOSappUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "UIKitCatalog-iphonesimulator.app";
                    caps.setCapability("simulatorStartupTimeout", 180000);
                    caps.setCapability("bundleId", "com.examplle.apple-samplecode.UICatalog");
                    return new IOSDriver(url, caps);
                default:
                    throw new IllegalArgumentException("Plataforma no soportada: " + platformName);
            }
        } catch (Exception e) {
            // Manejo genérico de errores en la inicialización del driver
            throw new RuntimeException("Error al inicializar el driver para la plataforma " + platformName + ": " + e.getMessage(), e);
        }

    }


}
