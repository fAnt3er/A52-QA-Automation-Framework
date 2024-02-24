import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlaylistPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RenamePlaylistTest extends BaseTest {

    LoginPage loginPage;
    PlaylistPage playlistPage;
    HomePage homePage;
    String currentPlaylistName = "Popmusic";
    String newPlayListName = "Classic";

    @Test(groups = "Smoke")
    public void renamePlaylist() {
        loginPage = new LoginPage(getDriver());
        loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        playlistPage = new PlaylistPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.doubleClickPlaylist(currentPlaylistName);
        homePage.enterNewPlaylistName(newPlayListName);
        Assert.assertTrue(homePage.getSuccessMessageLocator().isDisplayed());

    }

    @AfterMethod(groups = "smoke")
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