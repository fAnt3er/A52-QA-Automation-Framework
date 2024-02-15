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

    WebDriver pageDriver = null;

    @FindBy (xpath = "div[contains(@class,'success')]")
    WebElement successMessageLocator;

    public BasePage(WebDriver existDriver) {    //создания драйвера
        this.pageDriver = existDriver;
        PageFactory.initElements(pageDriver, this); // add for finding all @FindBy
    }

    public WebElement findElement(By locator) {   //искать илимент
        return pageDriver.findElement(locator);
    }

        public  WebElement waitAndFindWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void contextClickByElement(WebElement element) {
        Actions actions = new Actions(pageDriver);
        actions.contextClick(element).perform();
    }

    public WebElement getSuccessMessageLocator() {
        return successMessageLocator;
    }

//    public boolean isSuccessMessageDisplayed() {
//        return getSuccessMessageLocator().isDisplayed();
//    }

    public WebElement waitAndFindWebElement(WebDriverWait wait, By locator) {     //ждать и искать
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
