package odevler;

import org.bouncycastle.est.LimitedSource;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C07 extends TestBase {

@Test
    public void test01(){

   // Bir Class olusturun D19_WebtablesHomework
   // 1. “https://demoqa.com/webtables” sayfasina gidin

    driver.get("https://demoqa.com/webtables");
   // 2. Headers da bulunan department isimlerini yazdirin
    System.out.println("***** 2. TASK *****");
    List<WebElement> headerList=new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']")));
    headerList.stream().forEach(t-> System.out.println(t.getText()+" "));

   // 3. sutunun basligini yazdirin
    System.out.println("***** 3. TASK *****");
    System.out.println(driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]")).getText());

    // 4. Tablodaki tum datalari yazdirin
    System.out.println("***** 4. TASK *****");
    WebElement tumData=driver.findElement(By.xpath("//div[@class='rt-table']"));
    System.out.println(tumData.getText());

    // 5. Tabloda kac cell (data) oldugunu yazdirin
    System.out.println("***** 5. TASK *****");
    List<WebElement> cellList=new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-td']")));
    // List<WebElement> cellList=driver.findElements(By.xpath("//div[@class='rt-td']"));  BOYLE DE OLABİLİR
    System.out.println(cellList.size());

    // 6. Tablodaki satir sayisini yazdirin
    System.out.println("***** 6. TASK *****");
    List<WebElement> satirlarList=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
    System.out.println(satirlarList.size());

    // 7. Tablodaki sutun sayisini yazdirin
    System.out.println("***** 7. TASK *****");
    List<WebElement> sutunList=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
    System.out.println(sutunList.size());

   // 8. Tablodaki 3.kolonu yazdirin
    System.out.println("***** 8. TASK *****");
    List<WebElement> ucuncuKolon=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
    ucuncuKolon.stream().forEach(t->System.out.println(t.getText()+" "));

    // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    System.out.println("***** 9. TASK *****");
    WebElement kierraSalary=driver.findElement(By.xpath("//div[@class='rt-tr-group'][3]//div[@class='rt-td'][5]"));
    System.out.println(kierraSalary.getText());

    // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana
    // datayi yazdirsin
    int satirSayisi=3;
    int sutunSayisi=5;

    satirSutunMethod(satirSayisi,sutunSayisi);
}

    public void satirSutunMethod(int satirSayisi, int sutunSayisi) {
        System.out.println("***** 10. TASK *****");
        WebElement index=driver.findElement(By.xpath("//div[@class='rt-tr-group']["+satirSayisi+"]//div[@class='rt-td']["+sutunSayisi+"]"));
        System.out.println(index.getText());


    }


}
