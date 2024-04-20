package Gun05;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimeini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */
public class _03_SearchFunctionality extends GenelWebDriver {

@Test
@Parameters("keyword")
    void searchFunctionality(String keyword) {
        WebElement searchInputBox = driver.findElement(By.xpath("//input[@name=\"search\"]"));
        searchInputBox.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.xpath("//i[@class=\"fa fa-search\"]"));
        searchButton.click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"row\"][3]//div[@class=\"product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12\"]//div[@class=\"caption\"]//h4"));

    for (int i = 0; i < products.size(); i++) {
        Assert.assertTrue(products.get(i).getText().contains(keyword));
    }


  // for (int i = 0; i < products.size(); i++) {
  //     Assert.assertTrue(products.get(i).getText().toLowerCase().contains(keyword));
  // }



    }





}