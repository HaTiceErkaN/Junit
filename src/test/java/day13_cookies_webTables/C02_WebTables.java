package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test

    public void test01() throws InterruptedException {

        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!
        girisYap();
        //● table( ) metodu oluşturun
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
       List<WebElement> sutunBasliklari= driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi: "+sutunBasliklari.size());

        //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz

        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi: "+satirlarList.size());
        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:satirlarList) {
            System.out.println(w.getText());
        }
        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
List<WebElement> cellList= driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement w:cellList) {
            System.out.println(w.getText());
        }
        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarList=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i <basliklarList.size() ; i++) {
           if ( basliklarList.get(i).getText().equals("BirthDate")){
               emailSutunNo=i;
           };
        }
        List<WebElement> emailSutunList=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement w:emailSutunList) {
            System.out.println(w.getText());
        }

    }
    public void girisYap() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com/");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(3000);
    }
}
