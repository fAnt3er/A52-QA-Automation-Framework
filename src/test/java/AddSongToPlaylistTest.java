import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlaylistTest extends BaseTest {

    LoginPage loginPage;
    PlaylistPage playlistPage;

    HomePage homePage;

    @Test(groups = "smoke")
    public void addSongToPlaylist()  {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        String songName = "BornKing";
        String newPlaylistName = "Favorites";
        playlistPage = new PlaylistPage(getDriver());
        playlistPage.searchSong(songName);
        homePage.getViewButton().click();
        playlistPage.getSelectSong(songName).click();
        playlistPage.getAddInputButton().click();
        playlistPage.doubleClickByChoosePlaylist(newPlaylistName);
        Assert.assertTrue(playlistPage.getSearchSong(songName).isDisplayed());
    }
}
