package day09_handleWindows_tasteBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C02_handleWindows {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
    driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle=driver.getWindowHandle();

        // 2- url'in  amazon icerdigini test edelim
        driver.getCurrentUrl();
        Assert.assertTrue( driver.getCurrentUrl().contains("amazon"));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.bestbuy.com");
        String ikinciSayfaHandle= driver.getWindowHandle();

        // 4- title'in Best Buy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaHandle);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+Keys.ENTER);


        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("java"));


        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandle);

        // 8- logonun gorundugunu test edelim
        driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed();

    }
    }

