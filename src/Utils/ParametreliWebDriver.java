package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametreliWebDriver {

    public WebDriver driver;
    public static WebDriverWait wait;
    @Parameters("browser")
    @BeforeClass
    public void baslangicIslemleri(String browser){
        System.out.println("Driver started......");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        if (browser.equalsIgnoreCase("chrome")){

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE,"/dev/null");
            //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();//ekranı maximize yapar (tam ekran  değil de full ekran yani pencere halinde kalır.)
        driver.manage().deleteAllCookies();//çerezleri siler. site driver ile girdiğimizi anladığı için bize engel amaçlı bir cookie gonderır. bu kod da ilk defa gırıyormusuz gıobı yaptırır




        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));/**başta sayfa yüklenirken düzgün ve tamamen yüklenmesi için belirlediğim saniye (30sn) kadar sayfaya süre tanır. eğer sayfa hızlı ve düzgün yüklenirse bunu kullanmaz.**/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// bu da üstteki kod gibi farkı : bu, süre tanımayı her eleman için yapar.(bazen sayfa yüklenir ama bazı elemanlar  yuklenmez falan o yuzden) elemanın yüklenmesini bekler.


        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
logInIslemi();
    }

    @AfterClass
   public void bitisIslemleri(){
        System.out.println("Driver closed.......");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    void logInIslemi(){

        WebElement inputMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"email\"]")));
        inputMail.sendKeys("fenerbaba@hotmail.com");
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name=\"password\"]"));
        inputPassword.sendKeys("akinbaba");

        WebElement loginButton=driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginButton.click();
    }

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    



}
