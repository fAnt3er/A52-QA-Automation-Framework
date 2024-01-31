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
    @Test
    public void loginEmptyEmailPassword() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test(groups = "smoke")
    public void loginWithValidCredentials() {
        login("Yevhenii@testpro.io", "Fantazer120393!");
        WebElement header = driver.findElement(By.cssSelector("[id='userBadge']"));
        Assert.assertTrue(header.isDisplayed());

    }

    @Test(groups = "regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void LoginWithEmptyCredentials(String email, String password) {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login("", "");
        Assert.assertTrue(logo.isDisplayed());

    }
}