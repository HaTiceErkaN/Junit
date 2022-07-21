package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test0() throws InterruptedException {
        //amazon ana sayfaya gidip account menusunden create a list yapilacak
        Actions actions= new Actions(driver);
        driver.get("https://www.amazon.com");
      WebElement accountLinki= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
      actions.moveToElement(accountLinki).perform();
      driver.findElement(By.xpath("//*[text()='Create a List']")).click();

      Thread.sleep(50000);



    }
}
