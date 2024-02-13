package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage extends BasePage {

    @FindBy (xpath = "//span/button[contains(@title,'Delete')]")
    WebElement DeletePlaylist;

    @FindBy(css = "[type='search']")
    WebElement search;

    @FindBy(css = "[data-test='view-all-songs-btn']")
    WebElement viewButton;


    @FindBy (css = "[class='btn-add-to']")
    WebElement addInput;

    @FindBy (xpath = "//li[contains(@class,'$s')]/a")
    WebElement playlistName;

    @FindBy(css = "[id='progressPane']")
    WebElement soundBar;



    public PlaylistPage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getDeletePlaylist(WebDriverWait wait) {
        return DeletePlaylist;

    }

    public void deletePlaylist(WebDriverWait wait) {
        getDeletePlaylist(wait).click();
    }
    public WebElement getSearchSong(WebDriverWait wait) {
        return search;
    }

    public WebElement getViewButton(WebDriverWait wait) {
        return viewButton;
    }
    public WebElement getSelectSong(WebDriverWait wait, String selectSong) {
        return findElement(By.xpath(String.format("//tr/td[contains(text(),'%s')]", selectSong)));
    }

    public WebElement getAddInputButton(WebDriverWait wait) {
        return addInput;
    }

    public WebElement getSoundBar(WebDriverWait wait) {
        return soundBar;
    }

    public WebElement getChoosePlaylist(WebDriverWait wait, String playlistName ) {
        return findElement(By.xpath(String.format("//li[contains(@class,'$s')]/a", playlistName )));
    }

}

