package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void test01(){
        //http://automationpractice.com/index.php sayfasina gidelim//Sign in butonuna basalim
       //Email kutusuna @isareti olmayan bir mail yazip enter’a
        // bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        driver.get("http://automationpractice.com/index.php");
       driver.findElement(By.xpath("//a[@class='login']")).click();
       WebElement mailKutusu= driver.findElement(By.xpath("//input[@id='email']"));
       mailKutusu.sendKeys("h.erkangmail.com"+Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed());
    }
}
