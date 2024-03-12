package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenelWebDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIslemleri(){//diğer projedeki BaseStaticDriver classındaki başlangıç adımları kodlarını yapıştırdım buraya
        System.out.println("Driver started......");



        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        //  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();//ekranı maximize yapar (tam ekran  değil de full ekran yani pencere halinde kalır.)
        driver.manage().deleteAllCookies();//çerezleri siler. site driver ile girdiğimizi anladığı için bize engel amaçlı bir cookie gonderır. bu kod da ilk defa gırıyormusuz gıobı yaptırır




        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));/**başta sayfa yüklenirken düzgün ve tamamen yüklenmesi için belirlediğim saniye (30sn) kadar sayfaya süre tanır. eğer sayfa hızlı ve düzgün yüklenirse bunu kullanmaz.**/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// bu da üstteki kod gibi farkı : bu, süre tanımayı her eleman için yapar.(bazen sayfa yüklenir ama bazı elemanlar  yuklenmez falan o yuzden) elemanın yüklenmesini bekler.


        driver.get("https://opencart.abstracta.us/index.php?route=account/login");


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

}
