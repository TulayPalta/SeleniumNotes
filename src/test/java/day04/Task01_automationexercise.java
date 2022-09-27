package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Task01_automationexercise {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test() throws InterruptedException {
        // http://automationexercise.com sayfasına gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın
        WebElement test = driver.findElement(By.xpath("(//div[@class='col-sm-6'])[1]"));
        if (test.isDisplayed()){
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("Anasayfa testi FAILED");

        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        if (newUserSignup.isDisplayed()){
            System.out.println("New User Signup PASSED");
        }else System.out.println("New User Signup FAILED");

        //Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Tulay Palta");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("pa11ltabunyamin80@gmail.com");
        Thread.sleep(3000);

        // Click 'Signup' button
        WebElement click = driver.findElement(By.xpath("//*[text()='Signup']"));
        click.sendKeys(Keys.ENTER);

        //'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement hesapBilgileriYazisi = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (hesapBilgileriYazisi.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION PASSED");
        }else System.out.println("ENTER ACCOUNT INFORMATION FAILED");

        // Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi (Fill details: Title, Name, Email, Password, Date of birth)
        //TitleÇ
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();

        //Password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789");

        //Date of birth
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("16");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("March");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1993");

        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Devota");

        //Last name
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("qa");

        //Address
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("gül sokak 32 mahallesi");

        //Country
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("India");

        //State
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Kerala");

        //City
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Mumbai");

        //Zipcode
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("6");

        //Mobile Number
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+91 1111-123456");

        // Click 'Create Account button'
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).sendKeys(Keys.ENTER);

        // Verify that 'ACCOUNT CREATED!' is
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (accountCreated.isDisplayed()){
            System.out.println("ACCOUNT CREATED PASSED");
        }else System.out.println("ACCOUNT CREATED FAILED");

        // Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).sendKeys(Keys.ENTER);

        // Verify that 'Logged in as username' is visible
        WebElement loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));

        if (loggedInAs.isDisplayed()){
            System.out.println("Logged in as username PASSED");
        }else System.out.println("Logged in as username FAILED");

        // Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).sendKeys(Keys.ENTER);

        //Delete Account yazının görüldüğünü doğrulayın
        WebElement deleteAccount = driver.findElement(By.className("active"));
        if (deleteAccount.isDisplayed()){
            System.out.println("Delete Account PASSED");
        }else System.out.println("Delete Account FAILED");
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
