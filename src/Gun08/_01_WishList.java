package Gun08;

import Gun07._03_PlaceOrderElements;
import Utils.GenelWebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
    Senaryo ;
    1- Siteye gidiniz..
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elemanın Add Wish butonuna tıklatınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */

public class _01_WishList extends GenelWebDriver {
    @Test
    @Parameters("keyword")
    void wishList(String keyword){
        _03_PlaceOrderElements elements1=new _03_PlaceOrderElements(driver);
        _02_WishListElements elements=new _02_WishListElements(driver);

        elements1.searchInputBox.sendKeys(keyword);
        elements1.searchButton.click();


        int randomNumber = (int) (Math.random() * elements.productsThumbs.size());

        elements.wishListButtonsOnProducts.get(randomNumber).click();
        String productText=elements.productsThumbs.get(randomNumber).getText();
        System.out.println(elements.wishListButtonsOnProducts.get(randomNumber).getText());

        elements.wishListLink.click();


        boolean bulundu=false; //kontrol için bir boolean oluşturdum.
        for (WebElement e : elements.productsInWishList) {
            if (e.getText().equals(productText)){
                bulundu=true;
                break;
            }

        }

        System.out.println("bulundu mu ? = "+ bulundu);
        Assert.assertTrue(bulundu); //true değilse hata verecek

    }








}
