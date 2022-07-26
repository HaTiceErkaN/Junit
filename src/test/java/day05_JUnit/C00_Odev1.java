package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C00_Odev1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        1 https://the internet.herokuapp.com/add_remove_elements/ adresine gidin
        2Add Element butonuna basin
        3Delete butonu’nun gorunur oldugunu test edin
        4Delete tusuna basin
        5Add/Remove Elements ” yazisinin gorunur oldugunu test edin
         */

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@ onclick='addElement()']")).click();
        WebElement deleteButton= driver.findElement(By.xpath("//button[@ class='added-manually']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete Butonu Testi PASSED");
        }else{
            System.out.println("Delete Butonu Testi FAILED");
        }

        WebElement text = driver.findElement(By.xpath("//h3"));

        if (text.isDisplayed()){
            System.out.println("addRemoveYaziElementi testi PASSED");
        }else {
            System.out.println("addRemoveYaziElementi testi Failed");
        }
        driver.close();

    }
}
