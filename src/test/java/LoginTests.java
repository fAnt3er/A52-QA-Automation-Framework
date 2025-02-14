import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @Test(groups = "smoke")
    public void loginWithValidCredentials() {
        loginPage = new LoginPage(getDriver());
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.getHeader().isDisplayed());

    }

    @Test(groups = "regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void LoginWithEmptyCredentials(String email, String password) {
        loginPage = new LoginPage(getDriver());
        WebElement logo = getDriver().findElement(By.cssSelector(".logo"));
        loginPage.login("", "");
        Assert.assertTrue(loginPage.getlogo().isDisplayed());

    }
}
