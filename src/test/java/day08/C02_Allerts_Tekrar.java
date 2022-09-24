package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts_Tekrar {

    /*
    Bir class olusturun: Alerts
https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void acceptAlert() {

//      Bir metod olusturun: acceptAlert
//      1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//      “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement resultYazi = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String expectedYazi = "You successfully clicked an alert";
        String actualYazi = resultYazi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);
    }

    @Test
    public void dismissAlert() {

//      Bir metod olusturun: dismissAlert
//      2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//      “successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println("2.Buttonun Alert Mesajı = "+driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement resultYazi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualYazi = resultYazi.getText();
        String unExpectedYazi = "successfuly";
        Assert.assertFalse(actualYazi.contains(unExpectedYazi));
        System.out.println(actualYazi);
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

//      Bir metod olusturun: sendKeysAlert
//      3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//      tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Bunyamin");
        driver.switchTo().alert().accept();
        String actualYazi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedYazi="Bunyamin";
        Assert.assertTrue(actualYazi.contains(expectedYazi));

    }

}