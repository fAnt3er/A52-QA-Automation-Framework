import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {


    @Test(groups = "smoke")
    public void playSong() {
        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//a[text()='Popmusic']"));
        playlist.click();
        WebElement selectSong = driver.findElement(By.xpath("//td[contains(text(),'Airbit')]"));
        selectSong.click();
        WebElement soundBar = driver.findElement(By.cssSelector("[id='progressPane']"));
        Assert.assertTrue(soundBar.isDisplayed());


    }
}

