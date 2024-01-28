import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {

    @Test (groups = "smoke")
    public void RegistrationNavigation () {

        WebElement Registration = driver.findElement(By.cssSelector("[href='registration']"));
        Registration.click();
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.sendKeys("Yevhenii.Ustenko@testpro.io");
        emailInput.click();
        WebElement ConfirmationMessage = driver.findElement(By.cssSelector("[method='POST']"));
        Assert.assertTrue(ConfirmationMessage.isDisplayed());

    }
}


