package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/


public class _02_PlaceOrder extends GenelWebDriver {



    @Test
    void shoppingChart(){

        WebElement searchInputBox=driver.findElement(By.xpath("//input[@name=\"search\"]"));
        searchInputBox.sendKeys("ipod");

        WebElement searchButton = driver.findElement(By.xpath("//i[@class=\"fa fa-search\"]"));
        searchButton.click();

        WebElement addToCart1=driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]"));
        addToCart1.click();

        WebElement shoppingCart=driver.findElement(By.xpath("//a[text()='shopping cart']"));
        shoppingCart.click();

        WebElement checkoutBtn=driver.findElement(By.xpath("//a[text()='Checkout']"));
        checkoutBtn.click();

        WebElement continueBtn=driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        continueBtn.click();

        WebElement shippingAddressBtn=driver.findElement(By.id("button-shipping-address"));
        shippingAddressBtn.click();

        WebElement shippingMethodBtn=driver.findElement(By.id("button-shipping-method"));
        shippingMethodBtn.click();

        WebElement checkBox=driver.findElement(By.xpath("//input[@value=\"1\"]"));
        checkBox.click();

        WebElement paymentMethod=driver.findElement(By.xpath("//input[@value=\"cod\"]"));
        paymentMethod.click();

        WebElement paymentMethodContinueBtn=driver.findElement(By.id("button-payment-method"));
        paymentMethodContinueBtn.click();


        WebElement confirmOrderBtn=driver.findElement(By.xpath("//input[@id=\"button-confirm\"]"));
        confirmOrderBtn.click();

        List<WebElement> confirmMsg=driver.findElements(By.xpath("//h1[text()='Your order has been placed!']"));
        if (confirmMsg.size()>0)
        {
            Assert.assertTrue(confirmMsg.get(0).isDisplayed());
        }



    }


}
