package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C00_Odev {
    public static void main(String[] args) {
        /*
        1. Bir class oluşturun :
        AmazonSearchTest
        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        a
        .google web sayfasına gidin. https:// amazon .
        b. Search(ara) “city bike”
        c.
        Amazon 'da görüntülenen ilgili sonuçların sayısını yazdırın
        d. “Shopping” e tıklayın.
        e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");

       WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("city bike"+ Keys.ENTER);
       WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


    }
}
