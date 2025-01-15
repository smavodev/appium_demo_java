package StoreDemo;

import org.testng.annotations.Test;
import pageObjects.android.pages.FormPage;
import runners.BaseConfig;

public class TestCase1 extends BaseConfig {

    @Test
    public void testCase1() throws InterruptedException {
        FormPage formPage = new FormPage(driver);

        formPage.setCountrySelector("Argentina");
        formPage.setNameField("Yadira");
        formPage.setGenderFemale();
        formPage.setBntLetsShop();

        Thread.sleep(1000);
    }

}
