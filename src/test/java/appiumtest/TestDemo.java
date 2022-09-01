package appiumtest;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestDemo {

	//WebDriver driver; 
	 public static AppiumDriver<MobileElement> driver;
	//AndroidDriver driver; 
	
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
		
		cap.setCapability("deviceName", "Readmi Note 10S");
		cap.setCapability("udid", "DYNRTGJNN7OFK7AI");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12.0.0");
		cap.setCapability("appPackage", "pe.sura.afpintegraapp");
		cap.setCapability("appActivity", "pe.sura.afpintegraapp.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started ......");
		
	}
}
