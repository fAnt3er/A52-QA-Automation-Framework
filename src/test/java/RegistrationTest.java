import org.example.LoginPage;
import org.example.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    LoginPage loginPage;
    RegistrationPage registrationPage;



    @Test (groups = "smoke")
    @Parameters("email")
    public void RegistrationNavigation (String email) {
        loginPage = new LoginPage(getDriver());
        loginPage.clickRegistrationLink();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.fillEmail(email);
        registrationPage.clickSubmitButton();
        Assert.assertTrue(registrationPage.getConfirmationMessage().isDisplayed());
    }
}


