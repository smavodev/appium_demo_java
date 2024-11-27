package pageObjects.android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PrincipalPage {

    // Localizadores para los campos y botones
    @AndroidFindBy(id = "com.example.app:id/username")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.example.app:id/password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.example.app:id/loginButton")
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
