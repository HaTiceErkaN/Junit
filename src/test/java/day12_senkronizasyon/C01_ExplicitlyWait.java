package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    @Test
    public void implicitWaitTesti(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement yaziElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBack.isDisplayed());

    }
    @Test
    public void explicitlywaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
       /*
        WebElement yaziElementi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(yaziElementi));
        Assert.assertTrue(yaziElementi.isDisplayed());
        */
        /*
        yazinin gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapablir)
        Bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz
        */
        WebElement yaziElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(yaziElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));

        Assert.assertTrue(itsBackElementi.isDisplayed());

    }
    }

