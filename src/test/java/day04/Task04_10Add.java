package day04;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.time.Duration;
        import java.util.List;

public class Task04_10Add {
        /* 1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna 10 kez basinız
        3- 10 kez Add element butonuna basıldığını test ediniz
        4 -Delete butonuna görünmeyene kadar basınız
        5- Delete butonunun görünmediğini test ediniz
        6- Sayfayı kapatınız
         */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();

        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna 10 kez basinız
        //<button onclick="addElement()">Add Element</button>
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            addElement.click();
        }

        // 3- 10 kez Add element butonuna basıldığını test ediniz
        ////button[@class='added-manually']
        List<WebElement> deleteSayisi =driver.findElements(By.xpath("//button[@class='added-manually']"));
        if (deleteSayisi.size()==10) {
            System.out.println("DELETE TESTİ PASSED");
        }else System.out.println("DELETE TESTİ FAİLED");

        //4 -Delete butonuna görünmeyene kadar basınız
        for (int i = 10; i >0 ; i--) {
            Thread.sleep(1000);
            WebElement delete = driver.findElement(By.xpath("(//button[@class='added-manually'])["+i+"]"));
            delete.click();
        }

        // 5- Delete butonunun görünmediğini test ediniz
        ////*[@class='added-manually']
        List<WebElement> deleteSayisi2 =driver.findElements(By.xpath("//*[@class='added-manually']"));
        if (deleteSayisi2.size()==0){
            System.out.println("DELETE_BUTTON TESTİ PASSED");
        }else System.out.println("DELETE_BUTTON Testi FAILED");

        //6- Sayfayı kapatınız
        driver.quit();

    }
}