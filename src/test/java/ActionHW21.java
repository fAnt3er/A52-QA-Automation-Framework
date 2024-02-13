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

    BasePage basePage = null;

    String currentPlaylistName = "Popmusic";
    String newPlayListName = "Classic";


    @Test
    public void renamePlaylist()  {
        loginPage = new LoginPage(driver);
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        playlistPage = new PlaylistPage(driver);
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
        playlistPage.getChoosePlaylist(wait, currentPlaylistName);
        homePage.getEditButton(wait);
        homePage.getRenamePlayListInput(wait);
        for (int i = 0; i < currentPlaylistName.length(); i++) {
            homePage.getRenamePlayListInput(wait).sendKeys(Keys.BACK_SPACE);
        }
        homePage.getRenamePlayListInput(wait).sendKeys(newPlayListName);
        //homePage.getRenamePlayListInput(wait).sendKeys(Keys.ENTER);
        basePage.getSuccessMessageLocator();
        Assert.assertTrue(basePage.getSuccessMessageLocator().isDisplayed());

    }

    @AfterMethod

        public void rollBackPlayListName() {


        playlistPage.getChoosePlaylist(wait, currentPlaylistName);
        homePage.getEditButton(wait);
        homePage.getRenamePlayListInput(wait);
        for (int i = 0; i < currentPlaylistName.length(); i++) {
            homePage.getRenamePlayListInput(wait).sendKeys(Keys.BACK_SPACE);
        }
        homePage.getRenamePlayListInput(wait).sendKeys(currentPlaylistName);
        homePage.getRenamePlayListInput(wait).sendKeys(Keys.ENTER);


    }
}
