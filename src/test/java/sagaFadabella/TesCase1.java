package sagaFadabella;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.android.pages.PrincipalPage;
import pageObjects.android.pages.SearchPage;
import runners.Runner;

public class TesCase1 {

    public static void main(String[] args) throws Exception {
        try {
            AppiumDriver driver = Runner.initializeDriver("Android_emulador");

            PrincipalPage principalPage = new PrincipalPage((AndroidDriver) driver);
            SearchPage searchPage = new SearchPage((AndroidDriver) driver);
            Thread.sleep(5000);
            if (principalPage.getNotNow2().isDisplayed()) {
                principalPage.clickNotNow2();
                principalPage.clickCountrySelect(3);
            }

            Thread.sleep(15000);
            searchPage.searchBox();

            Thread.sleep(5000);
            searchPage.searchResult("Mac Book");
            searchPage.clickSearchResult(1);

        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
