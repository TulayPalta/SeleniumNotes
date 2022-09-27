package day00;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
public class Soru1 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement mainPage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(mainPage.isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        //6. Adı ve e-posta adresini girin
        WebElement isim = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(isim, "Tulay").sendKeys(Keys.TAB).sendKeys("hjklkj@gmail.com").perform();
        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        WebElement cinsiyet = driver.findElement(By.xpath("//*[@id='id_gender2']"));
        actions.click(cinsiyet).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB, "5").sendKeys(Keys.TAB, "April").
                sendKeys(Keys.TAB, "2016").perform();
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@id='optin']")).click();
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirk    et, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstName = driver.findElement(By.xpath("//*[@id='first_name']"));
        actions.sendKeys(firstName, "Habibe").sendKeys(Keys.TAB, "Soysal").sendKeys(Keys.TAB, Keys.TAB, "bursa").
                sendKeys(Keys.TAB, Keys.TAB, "Canada").sendKeys(Keys.TAB, "Student").sendKeys(Keys.TAB, "Toronto").sendKeys(Keys.TAB, "16020").
                sendKeys(Keys.TAB, "5521556216").perform();
        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //14. 'HESAP OLUŞTURULDU!' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed());
        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
    }
}