package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeClassAfterClass {
    protected static WebDriver driver;
    protected static Actions actions;
    protected static String tarih;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        actions = new Actions(driver);

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(formater);
        System.out.println(date);
        System.out.println(tarih);
    }
    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}