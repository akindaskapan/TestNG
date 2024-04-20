package Gun06;



import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
*/

public class _06_Task_3 extends GenelWebDriver {

    @Test
    void specialsValidation() {
        WebElement specialsButton = driver.findElement(By.xpath("//a[text()='Specials']"));
        specialsButton.click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@id=\"content\"]//div[@class=\"product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12\"]"));
        List<WebElement> discountedProducts = driver.findElements(By.xpath("//div[@id=\"content\"]//div[@class=\"product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12\"]//span[@class=\"price-new\"]"));

        Assert.assertEquals(products.size(), discountedProducts.size(), "Karşılaştırma sonucu");

        List<WebElement> newPriceList = driver.findElements(By.className("price-new"));
        List<WebElement> oldPriceList = driver.findElements(By.className("price-old"));

        /* ESKİ FİYAT - YENİ FİYAT KARŞILAŞTIRMASI */

        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue(Tools.WebElementStringToDouble(oldPriceList.get(i)) > Tools.WebElementStringToDouble(newPriceList.get(i)));

            System.out.println("Ürün " + (i + 1));
            System.out.println("Eski Fiyat = " + Tools.WebElementStringToDouble(oldPriceList.get(i)));
            System.out.println("Yeni Fiyat = " + Tools.WebElementStringToDouble(newPriceList.get(i)));
            System.out.println("----------------------------------------------------------------------");

        }

    }












}



