import net.bytebuddy.asm.Advice;
import org.example.BasePage;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionHW21 extends BaseTest {

    LoginPage loginPage = null;
    PlaylistPage playlistPage = null;
    HomePage homePage = null;
    String currentPlaylistName = "Popmusic";
    String newPlayListName = "Classic";

    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(getDriver());
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        playlistPage = new PlaylistPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.renamePlaylist(currentPlaylistName, newPlayListName);
        homePage.getRenamePlayListInput().sendKeys(Keys.ENTER);
        Assert.assertTrue(homePage.getSuccessMessageLocator().isDisplayed());

    }

    @AfterMethod
    public void rollBackPlayListName() {
        playlistPage.doubleClickByChoosePlaylist(newPlayListName);
        homePage.getRenamePlayListInput().click();
        for (int i = 0; i < newPlayListName.length(); i++) {
            homePage.getRenamePlayListInput().sendKeys(Keys.BACK_SPACE);
        }
        homePage.getRenamePlayListInput().sendKeys(currentPlaylistName);
        homePage.getRenamePlayListInput().sendKeys(Keys.ENTER);
    }
}