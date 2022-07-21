package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C00_Odev2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        1 C01_TekrarTesti isimli bir class olusturun
        2 https://www.amazon.com/ adresine gidin
        3 Browseri tam sayfa yapin
        4 Sayfayi “refresh” yapin
        5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        6 Gift Cards sekmesine basin
        7 Birthday butonuna basin
        8 Best Seller bolumunden ilk urunu tiklayin
        9 Gift card details’den 25 $’i secin
        10 Urun ucretinin 25$ oldugunu test edin
        10  Sayfayi kapatin
         */

        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        String actualTitle = driver.getTitle();
        String arananTitle="Spend less";

        if (actualTitle.contains(arananTitle)){
            System.out.println("Ttile testi PASSED");
        }else {
            System.out.println("Ttile testi FAILED");
        }

        driver.findElement(By.linkText("Gift Cards")).click();
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();
        driver.findElement(By.xpath("(//img[@ alt='Amazon.com eGift Card'])[1]")).click();
        driver.findElement(By.id("a-autoid-28")).click();
        WebElement actualPay= driver.findElement(By.xpath("//span[.='$25.00']"));
        String expectedPay= "$25.00";

        if (actualPay.getText().contains(expectedPay)){
            System.out.println("Ucret $25.00dir");
        }else{
            System.out.println("Ucret $25.00 degildir");
        }
        driver.close();





        }
    }

