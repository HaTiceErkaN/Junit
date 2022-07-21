package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C00_Odev3 {
    /*
    1 https://www.amazon.com/ sayfasina gidelim
    2 arama kutusunu locate edelim
    3--“Samsung headphones” ile arama yapalim
    4 Bulunan sonuc sayisini yazdiralim
    5 Ilk urunu tiklayalim
    6 Sayfadaki tum basliklari yazdiralim
     */
    WebDriver driver;

@Before

public void setUp() {
    WebDriverManager.chromedriver().setup();
     driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}

@After
public void close() {
      // driver.close();
}

@Test
        public void test01(){

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        System.out.println("sayfa basligi: "+driver.getTitle());

}
@Test
    public void test02() throws InterruptedException {
        /*
    1-https://www.google.com/ adresine gidin
    4-Sayfa basliginin “Google” ifadesi icerdigini test edin
    5-Arama cubuguna “Nutella” yazip aratin
    6-Bulunan sonuc sayisini yazdirin
    7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    8-Sayfayi kapatin
     */
    driver.get("https://www.google.com");
    String actualTitle= driver.getTitle();
    String expectedTite="Google";

    if (actualTitle.contains(expectedTite)){
        System.out.println("Title testi PASSED");
    }else{
        System.out.println("Title testi FAILED");
    }

    WebElement aramaCubugu= driver.findElement(By.xpath("//input[@title='Ara']"));
    aramaCubugu.sendKeys("Nutella"+Keys.ENTER);

    String [] sonucYazisi= driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
    String sonucSayisi= sonucYazisi[1];

    System.out.println("Sonuc Sayisi: "+sonucSayisi);

    int istenenSayi=10000000;

    sonucSayisi=(sonucSayisi.replaceAll("\\D",""));

    if (Integer.parseInt(sonucSayisi)>istenenSayi){
        System.out.println("Sonuc sayisi "+sonucSayisi+" > "+istenenSayi);
    }else{
        System.out.println("Sonuc sayisi "+sonucSayisi+" < "+istenenSayi);
    }

    Thread.sleep(3000);

}

@Test
    public void test03(){
     /*
    1. “https://www.saucedemo.com” Adresine gidin
    2. Username kutusuna “standard_user” yazdirin
    3. Password kutusuna “secret_sauce” yazdirin
    4. Login tusuna basin
    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6. Add to Cart butonuna basin
    7. Alisveris sepetine tiklayin
    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9. Sayfayi kapatin
     */

    driver.get("https://www.saucedemo.com");
    WebElement userName= driver.findElement(By.id("user-name"));
    userName.sendKeys("standard_user");
    WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
    password.sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    List<WebElement> urunIsimleri= driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
    String ilkUrun= urunIsimleri.get(0).getText();
    urunIsimleri.get(0).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.id("shopping_cart_container")).click();

    String sepettekiUrun= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

    if (sepettekiUrun.equals(ilkUrun)){
        System.out.println("Urun ekleme testi PASSED");
    }else{
        System.out.println("Urun ekleme testi FAILED");
    }


}

}
