import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPage;
import org.example.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.sql.DriverManager.getDriver;

public class NavigationTestDefinitions {



    WebDriver driver;

    @Before
    public void openBrowser()  {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       options.addArguments("--disable-notifications");
       driver = new ChromeDriver(options);
   }

    @Given("I open Login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }



    @When("I click on registration button")
    public void iClickOnRegistrationLink() {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.clickRegistrationLink();
      // driver.findElement(By.cssSelector("[href='registration']")).click();
   }


    @And("I enter email {string}")
    public void iEnterEmail(String arg0) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillEmail(arg0);
        // driver.findElement(By.cssSelector("[type='email']")).sendKeys(arg0);
    }


    @And("I submit")
    public void iSubmit() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSubmitButton();
        // driver.findElement(By.cssSelector("[type='submit']")).click();
    }


    @Then("I sees confirmation message")
    public void iSeesConfirmationMessage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.getConfirmationMessage();
        // driver.findElement(By.cssSelector("[method='POST']"));
    }

   // @And("I close browser")
    @After
    public void iCloseBrowser() {
       driver.quit();
    }
}
