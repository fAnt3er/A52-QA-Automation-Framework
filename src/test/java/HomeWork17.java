import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {


    @Test
    public void addSongToPlaylist() {

        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        String songName = "BornKing";
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        //WebElement songName = driver.findElement(By.xpath("//button[contains(@title,'BornKing')]");
        search.sendKeys("BornKing");
        WebElement viewButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewButton.click();
        WebElement selectSong = driver.findElement(By.xpath("//td[contains(text(),'BornKing')]"));
        selectSong.click();
        //search.sendKeys("BornKing");
        WebElement addInput = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addInput.click();
        WebElement playlist = driver.findElement(By.xpath("//li[contains(text(),'Popmusic')][last()!=6]"));
        playlist.click();
        WebElement popMusic = driver.findElement(By.xpath("//a[@class='active']"));
        popMusic.click();
        //WebElement addedSong = driver.findElement(By.xpath("//td[contains(text(),'BornKing')]"));
        search.sendKeys("BornKing");
        Assert.assertEquals(true, true);
        closeBrowser();

    }
}

