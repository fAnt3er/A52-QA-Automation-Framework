import net.bytebuddy.asm.Advice;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;


public class HomeWork19 extends BaseTest {

    LoginPage loginPage = null;
    HomePage homePage = null;

    @Test
    public void deletePlayList() {
        String newPlayList = "Popmusic";
        loginPage = new LoginPage(getDriver());
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        homePage = new HomePage(getDriver());
        homePage.creatPlayList(actions, newPlayList);
        homePage.openPlaylist(newPlayList);
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        playlistPage.deletePlaylist(wait);
        Assert.assertTrue(homePage.getPlaylistByName(newPlayList).isDisplayed());

    }
}
