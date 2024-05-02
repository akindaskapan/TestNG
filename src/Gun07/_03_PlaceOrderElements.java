package Gun07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
// bunun için aşağıdaki consructor eklendi ve için PageFatory ile
// driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
// Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
// anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
// aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
// gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
public class _03_PlaceOrderElements {

    public _03_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);  //aşağıdaki elementlerin hepsini driver ile ilişkilendirir.
    }
    @FindBy(xpath = "//input[@name=\"search\"]")
    public WebElement searchInputBox;

    @FindBy(xpath = "//i[@class=\"fa fa-search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    public WebElement addToCart1;

    @FindBy(xpath = "//a[text()='shopping cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    public WebElement continueBtn;

    @FindBy(id = "button-shipping-address")
    public WebElement shippingAddressBtn;

    @FindBy(id = "button-shipping-method")
    public WebElement shippingMethodBtn;


    @FindBy(xpath = "//input[@value=\"1\"]")
    public WebElement checkBox;


    @FindBy(xpath = "//input[@value=\"cod\"]")
    public WebElement paymentMethod;


    @FindBy(id = "button-payment-method")
    public WebElement paymentMethodContinueBtn;

    @FindBy(xpath = "//input[@id=\"button-confirm\"]")
    public WebElement confirmOrderBtn;

    @FindBy(css = "[id='content']>h1")
    public WebElement confirmText;


    //@FindBy(xpath = "(//div[@class='button-group']/button)[1]")
    //    public WebElement addToCart;


    //    @FindBy(css ="i[class='fa fa-shopping-cart']")
    //    public WebElement shoppingCart;




}
