package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JavaScriptExecutor extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButton=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButton);
        jse.executeScript("arguments[0].click();",signInButton);

        Thread.sleep(3000);
    }
}
