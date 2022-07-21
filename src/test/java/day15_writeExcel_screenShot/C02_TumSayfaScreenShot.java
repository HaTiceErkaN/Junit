package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        LocalDateTime date= LocalDateTime.now();
        System.out.println(date);
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih= date.format(dtf);
        System.out.println(tarih);
        File tumSayfa= new File("target/ekranGoruntuleri/"+tarih+".jpeg");
        File temp=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,tumSayfa);

    }
}
