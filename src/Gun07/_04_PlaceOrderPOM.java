package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends GenelWebDriver {

    @Test
    void proceedToCheckout(){

        _03_PlaceOrderElements elements=new _03_PlaceOrderElements(driver);

        elements.searchInputBox.sendKeys("ipod");

        elements.searchButton.click();
        elements.addToCart1.click();
        elements.shoppingCart.click();
        elements.checkoutBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingAddressBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingMethodBtn)).click();
        elements.checkBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentMethod)).click();
        elements.paymentMethodContinueBtn.click();

        elements.confirmOrderBtn.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement confirmText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='content']>h1")));

        Assert.assertEquals(confirmText.getText(),"Your order has been placed!","Karşılaştırma Sonucu : ");
    }


}
