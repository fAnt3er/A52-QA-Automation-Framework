package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.network.Header;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class HomePage extends BasePage {

     @FindBy (css = "[id='userBadge']")
     WebElement header;

     @FindBy (xpath = "//section//i[@data-testid='sidebar-create-playlist-btn']")
     WebElement PlaylistButton;

     @FindBy (css = "[data-testid='playlist-context-menu-create-simple']")
     WebElement CreateNewPlaylist;

     @FindBy (css = "[name='name']")
     WebElement NewPlayList;

    @FindBy(xpath = "//ul/li[contains(text(),'Edit')]")
     WebElement editButton;

    @FindBy (xpath = "//ul/li//input[@type='text']")
    WebElement renamePlayListInput;

     public HomePage(WebDriver existDriver) {
        super(existDriver);
    }

     public WebElement getHeader() {
        return header;
    }
     public WebElement getPlaylistButton(WebDriverWait wait) {
        return PlaylistButton;
    }

     public WebElement getCreateNewPlaylist(WebDriverWait wait) {
        return CreateNewPlaylist;
    }

     public WebElement getNewPlayList(WebDriverWait wait) {
        return NewPlayList;
    }

    public WebElement getEditButton(WebDriverWait wait) {
         return editButton;
    }

    public WebElement getRenamePlayListInput(WebDriverWait wait) {
         return renamePlayListInput;
    }

     public void creatPlayList(Actions actions, WebDriverWait wait, String newPlaylist) {
        actions.moveToElement(getPlaylistButton(wait)).perform();
        getPlaylistButton(wait).click();
        getCreateNewPlaylist(wait).click();
        getNewPlayList(wait).click();
        getNewPlayList(wait).sendKeys(newPlaylist);
        getNewPlayList(wait).sendKeys(Keys.ENTER);
    }

    public WebElement getPlaylistByName(String newPlaylist) {
         return findElement(By.xpath(String.format("//section[@id='playlists']//a[text()='%s']", newPlaylist)));
    }

    public void openPlaylist(String newPlaylist) {
        getPlaylistByName(newPlaylist).click();
    }
}
