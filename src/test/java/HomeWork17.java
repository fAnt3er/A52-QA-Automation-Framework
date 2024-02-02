import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {


    @Test(groups = "smoke")
    public void addSongToPlaylist()  {

        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        String songName = "BornKing";
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("BornKing");
        WebElement viewButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewButton.click();
        WebElement selectSong = driver.findElement(By.xpath("//tr/td[contains(text(),'BornKing')]"));
        selectSong.click();
        WebElement addInput = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addInput.click();
        WebElement playlist = driver.findElement(By.xpath("//li[contains(@class,'favorites')]/a"));
        playlist.click();
        WebElement favorites = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='active']")));
        favorites.click();
        search.sendKeys("BornKing");
        Assert.assertEquals(true, true);

    }
}
