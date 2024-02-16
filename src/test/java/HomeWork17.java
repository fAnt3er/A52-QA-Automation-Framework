import net.bytebuddy.asm.Advice;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {

    LoginPage loginPage = null;
    PlaylistPage playlistPage = null;

    @Test(groups = "smoke")
    public void addSongToPlaylist()  {
        loginPage = new LoginPage(getDriver());
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        String songName = "BornKing";
        String newPlaylistName = "Favorites";
        playlistPage = new PlaylistPage(getDriver());
        playlistPage.searchSong(songName);
        playlistPage.getViewButton().click();
        playlistPage.getSelectSong(songName).click();
        playlistPage.getAddInputButton().click();
        playlistPage.doubleClickByChoosePlaylist(newPlaylistName);
        Assert.assertTrue(playlistPage.getSelectSong(songName).isDisplayed());
    }
}
