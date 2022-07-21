package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.image.Kernel;
import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona gidip dropdown'dan books secenegini secip "java" aratalim, ve
    arama sonuclarinin java icerdigini test edelim
     */
    static WebDriver driver;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public  void tearDown(){
      //  driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        //dropdown'dan bir option secmek icin 3 adim vardir
        //1. adim dropdown'i locate edelim

       WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

       //2- bir select objesi olusturup parametre olarak bir önceki adimda locate ettiğimiz ddm'yu girelim
        Select select= new Select(dropDownMenu);

        //3- Dropdown'Da var olan optionlardan istedigimiz bir taneyi secelim
        select.selectByVisibleText("Books");
       // select.selectByIndex();
       // select.deselectByValue();

        //arama kutusuna java yazdiralim

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement sonucYazsisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String spnucYazisiStr=sonucYazsisiElementi.getText();
        String arananKelime="Java";

        Assert.assertTrue(spnucYazisiStr.contains(arananKelime));

        Thread.sleep(5000);

    }
}
