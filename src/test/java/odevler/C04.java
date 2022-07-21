package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //http ://zero.webappsecurity .com Adresine gidin  Sign in butonuna basin
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();

        //Login kutusuna “username” yazin
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginButton.sendKeys("username");

        //Password kutusuna “password.” yazin
        WebElement passwordButton=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordButton.sendKeys("password");

        //Sign in tusuna basin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();

        //  Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //Currency” drop down menusunden Eurozone’u secin
        Thread.sleep(3000);
        WebElement ddm=driver.findElement(By.id("pc_currency"));
        Select select=new Select(ddm);
        select.selectByValue("EUR");

        Thread.sleep(3000);


        //amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("500");

        //“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='pc_inDollars_true']")).isSelected());

        //“Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();

        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='alert_content']")).getText(),"Foreign currency cash was successfully purchased.");
    }
}




