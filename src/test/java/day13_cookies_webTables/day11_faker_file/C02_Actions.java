package day13_cookies_webTables.day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01(){
/*
        1- Bir Class olusturalim KeyboardActions
        2- https://html.com/tags/iframe/ sayfasina gidelim
        3- video’yu gorecek kadar asagi inin
        4- videoyu izlemek icin Play tusuna basin
        5- videoyu calistirdiginizi test edin

 */

        driver.get("https://html.com/tags/iframe/");
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        driver.switchTo().frame(iframe);

        //videoyu çalistiriginizi test edin

        WebElement youtubeLinki= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue( youtubeLinki.isDisplayed());




    }
}
