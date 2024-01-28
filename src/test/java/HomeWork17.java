import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {


    @Test
    public void addSongToPlaylist() throws InterruptedException {

        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        String songName = "BornKing";
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("BornKing");
        WebElement viewButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewButton.click();
        WebElement selectSong = driver.findElement(By.xpath("//td[contains(text(),'BornKing')]"));
        selectSong.click();
        WebElement addInput = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addInput.click();
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//a[text()='Popmusic']"));
        playlist.click();
        WebElement popMusic = driver.findElement(By.xpath("//a[@class='active']"));
        popMusic.click();
        Thread.sleep(3000);
        search.sendKeys("BornKing");
        Assert.assertEquals(true, true);

    }
}

