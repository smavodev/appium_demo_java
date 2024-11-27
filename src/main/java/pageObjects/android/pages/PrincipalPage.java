package pageObjects.android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PrincipalPage {

    // Localizadores para los campos y botones
    @AndroidFindBy(id = "pe.sura.afpintegraapp:id/inpDocumentNumber")
    private WebElement usernameField;

    @AndroidFindBy(id = "pe.sura.afpintegraapp/inpPassword")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ingresar']")
    private WebElement loginButton;

    // Métodos para interactuar con los elementos
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}
