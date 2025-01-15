package appiumIos;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

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

}
