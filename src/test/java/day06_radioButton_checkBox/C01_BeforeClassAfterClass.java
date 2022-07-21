package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {
 static    WebDriver driver;

     /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir
     */

    @BeforeClass
    public static  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterClass
    public void tearDown() {
        //Testin basinda before method call
        driver.close();
        //Testin sonunda after method call var gibi
    }

    @Test
    public void Test01() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void Test02() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void Test03() {
        driver.get("https://www.techproeducation.com");
    }
}
