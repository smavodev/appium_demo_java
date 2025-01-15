package e2eDemo;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseConfig;

public class Login extends BaseConfig {

    // Método para seleccionar un país
    private void selectCountry(String countryName) {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        String selectedCountry = scrollAndClick(driver, countryName);
        Assert.assertEquals(selectedCountry, countryName, "El país seleccionado no coincide.");
    }

    // Método para ingresar el nombre
    private void enterName(String name) {
        if (name != null) {
            driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
        }
    }

    // Método para seleccionar el género
    private void selectGender(boolean isFemale) {
        String genderId = isFemale
                ? "com.androidsample.generalstore:id/radioFemale"
                : "com.androidsample.generalstore:id/radioMale";
        driver.findElement(AppiumBy.id(genderId)).click();
    }

    // Método para hacer clic en el botón "Let's Shop"
    private void clickLetsShop() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

    // Método para verificar el mensaje de error (si existe)
    private void verifyToastMessage(String expectedMessage) {
        String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]"))
                .getAttribute("name");
        Assert.assertEquals(toastMessage, expectedMessage, "El mensaje del Toast no coincide.");
    }

    @Test
    public void Principal() throws InterruptedException {
        // Flujo principal
        selectCountry("Argentina");
        enterName("Elena");
        selectGender(true);
        clickLetsShop();
        Thread.sleep(3000);
    }

    @Test
    public void errorMessageValid() {
        // Flujo con error
        selectCountry("Argentina");
        enterName(null); // No se ingresa nombre
        selectGender(true);
        clickLetsShop();
        verifyToastMessage("Please enter your name");
    }

}
