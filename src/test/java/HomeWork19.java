import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class HomeWork19 extends BaseTest {

    @Test (groups = "smoke")

    public void deletePlaylist() throws InterruptedException  {

        login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
        WebElement SelectPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//a[text()='Popmusic']"));
        SelectPlaylist.click();
        WebElement DeletePlaylist = driver.findElement(By.xpath("//span/button[2]"));
        DeletePlaylist.click();
        Thread.sleep(3000);
        Assert.assertTrue(SelectPlaylist.isEnabled());

    }
}
