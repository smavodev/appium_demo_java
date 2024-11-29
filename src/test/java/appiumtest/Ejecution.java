package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.android.pages.PrincipalPage;
import runners.Runner;

public class Ejecution {

    public static void main(String[] args) throws Exception {
        try {
            AppiumDriver driver = Runner.initializeDriver("Android_emulador");

            PrincipalPage principalPage = new PrincipalPage((AndroidDriver) driver);
            Thread.sleep(3000);

//            if (principalPage.getNotNow_1.isDisplayed()) {
//                principalPage.clickNotNow1();
//            }

            if (principalPage.getNotNow2().isDisplayed()) {
                principalPage.clickNotNow2();
                principalPage.clickCountrySelect();
            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
