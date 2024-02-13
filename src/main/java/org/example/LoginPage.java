package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy (css = "[type='email']")
    WebElement emailInput;
    @FindBy (css = "[type='password']")
    WebElement passwordInput;
    @FindBy (css = "[type='submit']")
    WebElement loginButton;
    @FindBy (css = ".logo")
    WebElement logo;




    public LoginPage(WebDriver existDriver) {
        super(existDriver);
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);   //"Yevhenii.Ustenko@testpro.io"
        passwordInput.sendKeys(password);  //"Fantazer120393!"
        loginButton.click();
    }
    public WebElement getlogo() {
        return logo;


    }
}
