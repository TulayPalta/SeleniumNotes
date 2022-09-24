package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01_automationexercise1 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testMethod() throws InterruptedException {
//          1) http://automationexercise.com sayfasına gidin
        driver.get("http://automationexercise.com");

//          2) Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın
        WebElement mainPage= driver.findElement(By.xpath("(//*[@class='col-sm-6'])[1]"));
        if (mainPage.isDisplayed()){
            System.out.println("mainPage TEST PASSED");
        } else System.out.println("mainPage TEST FAILED");

//          3) Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

//          4) Verify 'New User Signup!' is visible
        WebElement SignUp = driver.findElement(By.xpath("//*[@class='signup-form']"));
        if(SignUp.isDisplayed()){
            System.out.println("SignUp TEST PASSED");
        } else System.out.println("SignUp TEST FAILED");

//          5) Enter name and email address
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("deneme");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("deneme11128@gmail.com");
        Thread.sleep(2000);

//          6) Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

//          7) 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement hesapbilgi=driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if(hesapbilgi.isDisplayed()){
            System.out.println("hesapbilgi TEST PASSED");
        } else System.out.println("hesapbilgi TEST FAILED");

//          8) Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //Title
        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();

        //Password
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("deneme");

        //Date of birth
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("4");
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("February");
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1994");

//          9) Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Ali");

        //Last name
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Kaya");

        //Company
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Google");

        //Address
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Adana");

        //Address2
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Seyhan");

        //Country
        driver.findElement(By.xpath("//*[@id='country']")).sendKeys("Turkey");

        //State
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Turkey");

        //City
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Istanbul");

        //Zipcode
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("34001");
        //Mobile Number
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("5564826535");

//          10) Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

//          11) Verify that 'ACCOUNT CREATED!' is
        WebElement account=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if(account.isDisplayed()){
            System.out.println("Account TEST PASSED");
        } else System.out.println("Account TEST FAILED");

//          12) Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

//          13) Verify that 'Logged in as username' is visible
        WebElement Logged=driver.findElement(By.xpath("//*[text()='deneme']"));
        if(Logged.isDisplayed()){
            System.out.println("Account TEST PASSED");
        } else System.out.println("Account TEST FAILED");

//          14) Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

//          15) Delete Account yazının görüldüğünü doğrulayın
        WebElement Delete=driver.findElement(By.xpath("//h1[text()='Delete Account']"));
        if(Delete.isDisplayed()){
            System.out.println("Account TEST PASSED");
        } else System.out.println("Account TEST FAILED");


    }
        @After
        public void tearDown(){
            driver.close();
        }
}