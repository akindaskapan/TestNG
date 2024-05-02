package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
   6- Continue butonlarına tıklatıp bilgileri giriniz.
   7- En son confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/


public class _02_PlaceOrder extends GenelWebDriver {



    @Test
    void proceedToCheckout(){

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

        WebElement continueBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Continue\"]")));
        continueBtn.click();

        WebElement shippingAddressBtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        shippingAddressBtn.click();

        WebElement shippingMethodBtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        shippingMethodBtn.click();

        WebElement checkBox=driver.findElement(By.xpath("//input[@value=\"1\"]"));
        checkBox.click();

        WebElement paymentMethod=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"cod\"]")));
        paymentMethod.click();

        WebElement paymentMethodContinueBtn=driver.findElement(By.id("button-payment-method"));
        paymentMethodContinueBtn.click();


        WebElement confirmOrderBtn=driver.findElement(By.xpath("//input[@id=\"button-confirm\"]"));
        confirmOrderBtn.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement confirmText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='content']>h1")));

        Assert.assertEquals(confirmText.getText(),"Your order has been placed!","Karşılaştırma Sonucu : ");
    }
}
