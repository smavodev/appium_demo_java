package mobileBrowserTest;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import runners.BaseConfigBrowser;

public class TestCase1 extends BaseConfigBrowser {

    @Test
    public void TestCase1() throws InterruptedException {

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Smavodev");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
    }

}
