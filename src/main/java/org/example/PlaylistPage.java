package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage extends BasePage {

    @FindBy(xpath = "//span/button[contains(@title,'Delete')]")
    WebElement DeletePlaylist;

    @FindBy(css = "[type='search']")
    WebElement search;

    @FindBy(css = "[class='btn-add-to']")
    WebElement addInput;


    @FindBy(css = "[id='progressPane']")
    WebElement soundBar;

    public PlaylistPage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getDeletePlaylist() {
        return DeletePlaylist;

    }

    public void deletePlaylist(WebDriverWait wait) {
        getDeletePlaylist().click();
    }

    public WebElement getSearchSong() {
        return search;
    }

    public void searchSong(String songName) {
        getSearchSong().sendKeys(songName);
    }


    public WebElement getSelectSong(String selectSong) {
    return findElement(By.xpath(String.format("//tr/td[contains(text(),'%s')]", selectSong)));
    }


    public WebElement getAddInputButton() {
        return addInput;
    }

    public WebElement getSoundBar() {
        return soundBar;
    }


   public void doubleClickByChoosePlaylist(String playlistName) {
      WebElement playList = waitAndFindWebElement(By.xpath(String.format("//li//a[text()='%s']", playlistName)));
      Actions actions = new Actions(pageDriver);
      actions.doubleClick(playList);
    }

}


 //public void doubleClickByChooseSong (String songName) {
   // WebElement song = waitAndFindWebElement(By.xpath(String.format("//tr/td[contains(text(),'%s'", songName)));
   // Actions actions = new Actions(pageDriver);
   //actions.doubleClick(song);
//}


