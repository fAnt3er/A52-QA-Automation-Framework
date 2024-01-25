import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends LoginTests {

    @Test
    public void RegistrationNavigation(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement Registration = driver.findElement(By.cssSelector("[href='registration']"));
        Registration.click();
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.sendKeys("Yevhenii.Ustenko@testpro.io");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement ConfirmationMessage = driver.findElement(By.cssSelector("[method='POST']"));
        Assert.assertTrue(ConfirmationMessage.isDisplayed());
        driver.quit();

    }

}

