package day04;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import java.time.Duration;

public class Task05_Amazon {
    public static void main(String[] args) throws InterruptedException {
    /*
2 https://www.amazon.com/ adresine gidin
3 Browseri tam sayfa yapin
4 Sayfayi "refresh" yapin
5 Sayfa basliginin "Spend less" ifadesi icerdigini test edin
6 Gift Cards sekmesine basin
7 Birthday butonuna basin
8 Best Seller bolumunden ilk urunu tiklayin
9 Gift card details'den 25 $'i secin
10 Urun ucretinin 25$ oldugunu test edin
11 Sayfayi kapatin
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//          2. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

//          3. Browseri tam sayfa yapin
        driver.manage().window().maximize();

//          4. Sayfayi "refresh" yapin
        driver.navigate().refresh();

//          5. Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Spend less")) {
            System.out.println("Title Test PASSED");
        } else System.out.println("Title Test FAILED");

//          6. Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

//          7. Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();


//          8. Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();
        Thread.sleep(3000);
        // driver.findElement(By.xpath("//*[@alt='Amazon.com eGift Card']")).click();

//          9. Gift card details'den 25 $'i secin
        WebElement ucret= driver.findElement(By.xpath("(//*[@class='a-button-text'])[25]"));
        ucret.click();
        Thread.sleep(2000);

//          10. Urun ucretinin 25$ oldugunu test edin
        WebElement urunUcreti=driver.findElement(By.xpath("//*[@id='gc-live-preview-amount']"));
        String dolar=ucret.getText();
        if(dolar.equals("$25")){
            System.out.println("25 dolarlik kart secildi :)");
        } else System.out.println("25 dolarlik kart secilemedi :(");

//          11. Sayfayi kapatin
        driver.close();

    }
}
