package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        // ingilizce baskentler sutununu yazdiralim
       int sonStir= workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonStir);
        String satirdakiData="";

        for (int i = 0; i <=sonStir ; i++) {
satirdakiData=C03_ReadExcel.dataGetir(i,1);
        }

    }
}
