package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01(){
        //  1)Bir class oluşturun: Youtube Assertions
        //   2)https://www.youtube.com adresine gidin
        //   3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

         //  titleTest => Sayfa başlığının YouTube ” oldugunu test edin
        // imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        driver.get("https://www.youtube.com");

        Assert.assertEquals(driver.getTitle(),"YouTube");
        driver.findElement(By.xpath("//yt-icon[@id='logo-icon']")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='search']")).isDisplayed();
        Assert.assertFalse(driver.getTitle().equals("youtube"));



    }

}
