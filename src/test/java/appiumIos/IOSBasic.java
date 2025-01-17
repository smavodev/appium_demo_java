package appiumIos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IOSBasic extends  BaseConfig{

    @Test
    public void IOSBasicTest(){
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField")).sendKeys("Demo de prueba");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm / Cancel\"")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm\"")).click();
    }

    @Test
    public void IOSLongerPress(){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement ele = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[3]"));

        Map<String,Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params);
    }

    @Test
    public void IOSScrollTest() throws InterruptedException {

        Map<String,Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("percent", 0.25);  // Porcentaje del desplazamiento (opcional, controla la distancia)

        driver.executeScript("mobile:scroll", params);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(2000);

        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
    }

    @Test
    public void IOSPickerTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("90");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");

        String number = driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
        Assert.assertEquals(number, "105");
        System.out.println(number);
        Thread.sleep(2000);
    }

}
