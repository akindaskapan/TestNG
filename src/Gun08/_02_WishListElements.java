package Gun08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements {


    public _02_WishListElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-original-title=\"Add to Wish List\"]")
    List<WebElement> wishListButtonsOnProducts;


    @FindBy(xpath = "//div//h4")
    List<WebElement> productsThumbs;

    @FindBy(xpath = "//a[text()='Wish List']")
    public WebElement wishListLink;

    @FindBy(xpath = "//td[@class=\"text-left\"]//a")
    List<WebElement> productsInWishList;


}
