package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_tekrar {
    static WebDriver driver;
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//     * https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
    @Test
    public void titleTest() {
//     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle= "YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
//     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement webLogo= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(webLogo.isDisplayed());
    }

    @Test
    public void erisilebilirlikTest() {
//     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isDisplayed());
    }
    @Test
    public void wrongTitleTest() {
//     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String unExpectedTitle="youtube";
        Assert.assertNotEquals(unExpectedTitle,actualTitle);
    }

}


