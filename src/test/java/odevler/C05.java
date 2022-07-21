package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C05 extends TestBase {

    @Test
    public void test01() {

        // https://www.amazon.com adresine gidin.
        // Test : Amazon ana sayfaya gittiginizi test edin
        // Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin

        // Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        // $16.83 oldugunu test edin
        //1-amazona git ve ana sayfanin goruntulendigini dogrula
        driver.get("https://www.amazon.com/");
        WebElement amazonHomePage=driver.findElement(By.xpath("//html[@lang='en-us']"));
        Assert.assertTrue(amazonHomePage.isDisplayed());

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Nutella"));

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement urunFiyati= driver.findElement(By.xpath("(//span[@aria-hidden='true'])[2]"));



        /*
        //1-amazona git ve ana sayfanin goruntulendigini dogrula
        driver.get("https://www.amazon.com/");
        WebElement amazonHomePage=driver.findElement(By.xpath("//html[@lang='en-us']"));
        Assert.assertTrue(amazonHomePage.isDisplayed());
         */



    }
}
