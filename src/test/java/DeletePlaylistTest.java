import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeletePlaylistTest extends BaseTest {

    LoginPage loginPage = null;
    HomePage homePage = null;

    @Test(groups = "smoke")
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
