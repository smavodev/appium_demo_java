package appiumIos;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasic extends  BaseConfig{

    @Test
    public void IOSBasicTest(){
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")).click();

    }

}
