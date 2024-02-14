package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    @FindBy(css = "[type='email']")
    WebElement emailInput;

    @FindBy(css = "[method='POST']")
    WebElement ConfirmationMessage;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    public RegistrationPage(WebDriver existDriver) {
        super(existDriver);

    }

    private LoginPage emailInput(String email) {
        emailInput.sendKeys(email);
        return null;
    }

    public WebElement getConfirmationMessage() {
        return ConfirmationMessage;
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}





