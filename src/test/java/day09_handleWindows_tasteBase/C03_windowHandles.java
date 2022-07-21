package day09_handleWindows_tasteBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle= driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text= driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(text.getText(),"Opening a new window");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(),"The Internet");
        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */
        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin woindow handle degeridir deriz
         */

        Set<String > windowHandle= driver.getWindowHandles();
        String ikinciWindowHandle="";
        for (String w:windowHandle) {
            if (!ilkSayfaWindowHandle.equals(w)){
                ikinciWindowHandle=w;
            }

        }
        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz

        driver.switchTo().window(ikinciWindowHandle);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Assert.assertEquals(driver.getTitle(),"New Window");


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaText=driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(ikinciSayfaText.getText(),"New Window");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");



    }
}
