package day04;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

//        2-https://www.google.com/adresinegidin
//        3-cookies uyarisini kabul ederek kapatin
//        4Sayfa basliginin"Google"ifadesiicerdiginitestedin
//        5Aramacubuguna"Nutella"yaziparatin
//        6Bulunansonucsayisiniyazdirin
//        7sonucsayisinin10milyon'danfazlaoldugunutestedin
//        8Sayfayikapatin

public class Task03_Nutella_Lambda {
        static WebDriver driver;

        @BeforeClass
        public static void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void googleTest(){
            driver.get("https://www.google.com");

            //4-Sayfa basliginin "Google" ifadesi icerdigini test edin
            Assert.assertTrue("Title Contains \"Google\" ",driver.getTitle().contains("Google"));
            //5-Arama cubuguna "Nutella" yazip aratin
            WebElement searchBox = driver.findElement(By.xpath("//input[@name = 'q']"));
            searchBox.sendKeys("Nutella", Keys.ENTER);

            //6-Bulunan sonuc sayisini yazdirin
            WebElement resultNoteElement = driver.findElement(By.xpath("//div[@id = 'result-stats']"));
            String resultNote = resultNoteElement.getText();
            Arrays.stream(resultNote.split(" ")).limit(2).skip(1).forEach(System.out::println);

            //7-sonuc sayisinin 10milyon'dan fazla oldugunu test edin
            Double resultNumber = Double.parseDouble(resultNote.replaceAll("[^0-9]",""));
            System.out.println(resultNumber);

            Assert.assertTrue("Result number bigger than 10 million",resultNumber>10000000);

        }
        @AfterClass
        public static void tearDown(){
            driver.close();
        }
    }