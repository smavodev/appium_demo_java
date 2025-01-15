package appiumtest;

import java.net.URL;
import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;

public class TestDemo {

	 public static AndroidDriver driver;
//	public static AppiumDriver<MobileElement> driver;

	public static void main(String[] args ) {
		try {
			openCalculator();
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static void openCalculator() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Pixel 8 API 33");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "12.0.0");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("avd", "Pixel_8");  // Inicia el simulador android de manera automatica
		cap.setCapability("avdLaunchTimeout", 180000); // Tiempo de espera de lanzamiento del simulador en automatico
//		cap.setCapability("appPackage", "pe.sura.afpintegraapp");
//		cap.setCapability("appActivity", "pe.sura.afpintegraapp.MainActivity");

		String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
		cap.setCapability("app", appUrl);

		URL url = new URL("http://127.0.0.1:4723");
//		driver = new AppiumDriver<MobileElement>(url, cap);
		driver = new AndroidDriver(url, cap);
		
		System.out.println("Application Started ......");
		
	}
}
