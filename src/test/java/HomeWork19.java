import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class HomeWork19 extends BaseTest {

    @Test (groups = "smoke")

    public void deletePlaylist() {

        String NewPlaylsit = "Popmusic";
        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section//i[@data-testid='sidebar-create-playlist-btn']")));
        WebElement PlaylistButton = driver.findElement(By.xpath("//section//i[@data-testid='sidebar-create-playlist-btn']"));
        PlaylistButton.click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"))));
        WebElement CreateNewPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        CreateNewPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        WebElement SafePlaylist = driver.findElement(By.cssSelector("[name='name']"));
        SafePlaylist.sendKeys(NewPlaylsit);
        SafePlaylist.sendKeys(Keys.ENTER);


        WebElement SelectPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//a[text()='Popmusic']"));
        SelectPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/button[contains(@title,'Delete')] ")));
        WebElement DeletePlaylist = driver.findElement(By.xpath("//span/button[contains(@title,'Delete')] "));
        DeletePlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[text()='Popmusic']")));
        Assert.assertTrue(SelectPlaylist.isDisplayed());

    }
}

