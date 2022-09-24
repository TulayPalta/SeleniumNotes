package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    // Before notasyonu her testten önce çalışır
    WebDriver driver;
    //  @Before da method ismi genelde setup olur ama istedigimiz isimde olabilir
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method1(){
        // 1 defa before methodu çalışır
        driver.get("https://amazon.com");
        // 1 defa da after methodu çalışır

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sarelle");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("sarelle");;
    }

    @After
    public void tearDown
            (){
        // After notasyonu her testten sonra çalışır
        driver.close();
    }

   /*
    8 locators.
            id, class, classname, linkText, css, xpath est.

    */

}
