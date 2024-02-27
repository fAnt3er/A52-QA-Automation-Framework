package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.time.Duration;

public abstract class BasePage {   // общий класс

    protected Actions actions;
    protected WebDriverWait wait;
    protected WebDriver driver;


    @FindBy(xpath = "div[contains(@class,'success show')]")
    public WebElement successMessageLocator;

    public BasePage(WebDriver driver) {    //создания драйвера
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this); // add for finding all @FindBy
    }

    public WebElement findElement(By locator) {   //искать илимент
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitAndFindWebElement(By locator) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void contextClickByElement(WebElement element) {
        actions.contextClick(element).perform();
    }

    public WebElement getSuccessMessageLocator() {
        return wait.until(ExpectedConditions.visibilityOf(successMessageLocator));
    }
}