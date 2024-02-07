import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionHW21 extends BaseTest {

    String currentPlaylistName = "Popmusic";
    String newPlayListName = "Classic";


    @Test
    public void renamePlaylist()  {


        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//a[contains(text(),'%s')]", currentPlaylistName))));
        actions.contextClick(playlist).perform();
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[contains(text(),'Edit')]")));
        editButton.click();
        WebElement renamePlayListInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//input[@type='text']")));
        for (int i = 0; i < currentPlaylistName.length(); i++) {
            renamePlayListInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlayListInput.sendKeys(newPlayListName);
        renamePlayListInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'success')]")));
        Assert.assertEquals(newPlayListName, playlist.getText());

    }

    @AfterMethod

        public void rollBackPlayListName() {


        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//a[contains(text(),'%s')]", newPlayListName))));
        actions.contextClick(playlist).perform();
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[contains(text(),'Edit')]")));
        actions.click(editButton).perform();
        WebElement renamePlayListInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//input[@type='text']")));
        for (int i = 0; i < newPlayListName.length(); i++) {
            renamePlayListInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlayListInput.sendKeys(currentPlaylistName);
        renamePlayListInput.sendKeys(Keys.ENTER);


    }
}
