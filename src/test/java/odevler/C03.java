package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C03 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //  https://the internet.herokuapp.com/dropdown adresine gidin.
        //  Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //Tüm dropdown değerleri(value) yazdırın
        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option1= new Select(ddm);
        option1.selectByIndex(1);
        System.out.println(option1.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        Select option2=new Select(ddm);
        option2.selectByValue("2");
        System.out.println(option2.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        Select option1visible=new Select(ddm);
        option1visible.selectByVisibleText("Option 1");
        System.out.println(option1visible.getFirstSelectedOption().getText());

        Select select= new Select(ddm);
        List<WebElement > selectList=select.getOptions();

        selectList.stream().forEach(t-> System.out.println(t.getText()));

        int dropDownBoyut=selectList.size();

        if (dropDownBoyut==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


    }
}
