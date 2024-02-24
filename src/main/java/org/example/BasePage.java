package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {   // общий класс

    protected Actions actions;
    protected WebDriverWait wait;
    protected WebDriver driver;


    @FindBy(xpath = "div[contains(@class,'success')]")
    WebElement successMessageLocator;

    public BasePage(WebDriver driver) {    //создания драйвера
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this); // add for finding all @FindBy
    }

    public WebElement findElement(By locator) {   //искать илимент
        return driver.findElement(locator);
    }

    public WebElement waitAndFindWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void contextClickByElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public WebElement getSuccessMessageLocator() {
        WaitUtils.waitUntilVisibilityOfElement(driver, successMessageLocator);
        return successMessageLocator;
    }
}