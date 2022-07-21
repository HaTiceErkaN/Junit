package day13_cookies_webTables.day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        // C:\Users\Hatice Erkan\IdeaProjects\com.batch59JUnit
        //icinde oldugumuz projenin dosya yolunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Hatice Erkan
        //benim bilgisayarimin bana özel kismini verir

        // C:\Users\Hatice Erkan\Downloads
        // C:\Users\Hatice Erkan\Desktop

        //  homePath + "\Downloads"


        //Masaüstümüzdeki text dosyasinin varliğini test edelim

        // C:\Users\Hatice Erkan\Desktop\text.txt

        String dosyaYolu= System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varliğini kontrol etmek için önce o dosyaya ulaşiriz sonra dosyanin dosya yolunu
        kopyalariz. Her bilgisayarin kullanici adi farkli olacağindan masaüstü dosya yolu da farkli olacaktir. Testlerimizin
        tüm bilgisyaarlarda çalişmasi için dosya yolunu dinamik yapmaliyiz
         */

       // Bunun için
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text.txt";

        String mdosyaYolu= farkliKisim+ortakKisim;

        //Dosyanin masaüstünde var olup omadiğini kontrol etmek için;

        System.out.println(Files.exists(Paths.get(mdosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(mdosyaYolu)));

    }
}
