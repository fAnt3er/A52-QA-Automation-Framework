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
        loginPage = new LoginPage(driver);
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        String songName = "BornKing";
        String newPlaylistName = "Favorites";
        playlistPage = new PlaylistPage(driver);
        playlistPage.getSearchSong(wait);
        playlistPage.getViewButton(wait);
        playlistPage.getSelectSong(wait, songName);
        playlistPage.getAddInputButton(wait);
        playlistPage.getChoosePlaylist(wait, newPlaylistName);
        Assert.assertTrue(playlistPage.getSelectSong(wait, songName).isDisplayed());

    }

}
