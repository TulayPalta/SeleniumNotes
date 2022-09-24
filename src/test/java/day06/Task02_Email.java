package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Task02_Email {
    // 1.Bir Class olusturalimYanlisEmailTesti
    // 2.http://automationpractice.com/index.php sayfasinagidelim
    // 3.Sign in butonunabasalim
    // 4.Email kutusuna @isareti olmayan bir mail yazipenter'a
    // 5.bastigimizda “Invalid email address” uyarisi ciktigini test edelim

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
    public void test1(){
        //3.Sign in butonunabasalim
        driver.findElement(By.xpath("//a[@class='login']")).click();
    }
    @Test
    public void test2(){
        //4.Email kutusuna @isareti olmayan bir mail yazip enter'a basınız
        driver.findElement(By.id("newsletter-input")).sendKeys("zzzgmail.com", Keys.ENTER);
    }
    @Test
    public void test3(){
        // 5.bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='alert alert-danger']")).isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
