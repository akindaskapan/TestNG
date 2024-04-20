package Gun06;


import Utils.ParametreliWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Bir önceki task'da yapılan testi PARAMETERDRIVER ile yapınız
 * sonrasında fakrlı tarayıcılar ile çalıştırınız.
 * sonrasında paralel çalıştırınız.
 */


public class _05_Task_2 extends ParametreliWebDriver {

    @Test(dataProvider = "keywords")
    void  searchFunctionality(String keywords){

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@name=\"search\"]"));
        searchInputBox.clear();
        searchInputBox.sendKeys(keywords);

        WebElement searchButton = driver.findElement(By.xpath("//i[@class=\"fa fa-search\"]"));
        searchButton.click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"row\"][3]//div[@class=\"product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12\"]//div[@class=\"caption\"]//h4"));


        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue(products.get(i).getText().toLowerCase().contains(keywords));
        }


    }
    @DataProvider
    public Object[] keywords(){

        Object[] data={"mac" , "ipod" , "samsung"};
        return data;
    }

}
