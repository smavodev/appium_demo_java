package appiumIos;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

}
