import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {


    @Test
    public void addSongToPlaylist() {

        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        WebElement Search = driver.findElement(By.cssSelector("[type='search']"));
        WebElement selectSong = driver.findElement(By.xpath("//button[contains(@title,'BornKing')]");
        selectSong.click();
        WebElement viewButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewButton.click();
        WebElement songName = driver.findElement(By.xpath("//td[contains(text(),'BornKing')]"));
        songName.click();
        WebElement addInput = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        WebElement playlist = driver.findElement(By.xpath("//li[contains(text(),'Popmusic')]"));
        playlist.click();
        WebElement addedSong = driver.findElement(By.xpath("//td[contains(text(),'BornKing')]"));
        Assert.assertEquals();
        closeBrowser();


    }
}
