package mobileBrowserTest;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfigBrowser;

public class TestCase1 extends BaseConfigBrowser {

    @Test
    public void testCase1() throws InterruptedException {

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Smavodev");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
    }

    @Test
    public void testCase2() throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("(//button[@class='navbar-toggle'])[1]")).click();
        driver.findElement(By.xpath("(//a[contains(.,'Courses')])[1]")).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        String text = driver.findElement(By.xpath("//div[contains(@title,'JavaScript SDET- Automation Testing Package -5 Courses Bundle')]")).getText();
        Assert.assertEquals(text, "JavaScript SDET- Automation Testing Package -5 Courses Bundle");
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
    }

}
