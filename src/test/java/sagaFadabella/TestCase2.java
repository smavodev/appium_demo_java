package sagaFadabella;

import org.testng.annotations.Test;
import pageObjects.android.pages.PrincipalPage;
import pageObjects.android.pages.SearchPage;
import runners.Config;

public class TestCase2 extends Config {

    @Test
    public void testCase2() throws InterruptedException {

        PrincipalPage principalPage = new PrincipalPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        Thread.sleep(5000);
        if (principalPage.getNotNow_1.isDisplayed()) {
            principalPage.clickNotNow1();
            principalPage.clickCountrySelect(3);
        }

        // if (principalPage.getNotNow2().isDisplayed()) {
        //   principalPage.clickNotNow2();
        //   principalPage.clickCountrySelect(3);
        // }

        Thread.sleep(15000);
        searchPage.searchBox();

        Thread.sleep(5000);
        searchPage.searchResult("Mac Book Air");
        searchPage.clickSearchResult(1);
    }

}
