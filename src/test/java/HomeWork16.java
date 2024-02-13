import org.example.LoginPage;
import org.example.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {

    LoginPage loginPage = null;
    RegistrationPage registrationPage = null;

    @Test (groups = "smoke")
    public void RegistrationNavigation (String email) {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage.login("Yevhenii.Ustenko@testpro.io", "");
        Assert.assertTrue(registrationPage.getConfirmationMessage().isDisplayed());

    }
}


