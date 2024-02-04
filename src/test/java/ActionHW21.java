import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionHW21 extends BaseTest{


    @Test
    public void renamePlaylist() throws InterruptedException {
        String playlistLocator = "//a[contains(text(),'$s')]";
        String newPlaylistName = "Jaz";


        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Homework')]")));
        actions.contextClick(playlist).perform();
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[contains(text(),'Edit')]")));
        actions.click(editButton).perform();
        WebElement renameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//ul/li//input[@type='text']")));
        Thread.sleep(4000);
        renameField.sendKeys(newPlaylistName);
        renameField.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        //WebElement renamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(playlistLocator, newPlaylistName))));
        //actions.click(renamePlaylist).perform();

        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Jaz')]")));
        actions.click(newPlaylist).perform();
        Assert.assertTrue(newPlaylist.isDisplayed());


    }
}
