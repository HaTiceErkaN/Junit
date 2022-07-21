package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String  dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook wb= WorkbookFactory.create(fis);
        // sayfa 2'ye gidip
        // satir sayisinin , kullanilan satir sayisinin ise 12 oldugunu test edin
        int sonSatirIndex=wb.getSheet("Sayfa2").getLastRowNum();
        int expectedSatirSayisi=23;

        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);

        int KullanilanSatirSayisi= wb.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi=16;
        Assert.assertEquals(expectedKullanilanSatirSayisi,KullanilanSatirSayisi);

    }
    }
