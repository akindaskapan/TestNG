package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
/*
        Senaryo;
        1- Siteyi açınız
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.
        3-İsimlerinin sıralı olduğunu doğrulayınız.
     */
public class _01_validateMenu extends GenelWebDriver {
    @Test
    void validateMenu(){

        /**BU ŞEKİLDE AYIRABİLİRİM (değişken ismi By)*/
        By menuIsimleri=By.xpath("//div[@class=\"collapse navbar-collapse navbar-ex1-collapse\"]/ul/li");
        List<WebElement> topMenu= GenelWebDriver.driver.findElements(menuIsimleri);
//1.yöntem
  //    Assert.assertEquals("Desktops",topMenu.get(0).getText());
  //    Assert.assertEquals("Laptops & Notebooks",topMenu.get(1).getText());
  //    Assert.assertEquals("Components",topMenu.get(2).getText());
  //    Assert.assertEquals("Tablets",topMenu.get(3).getText());
  //    Assert.assertEquals("Software",topMenu.get(4).getText());
  //    Assert.assertEquals("Phones & PDAs",topMenu.get(5).getText());
  //    Assert.assertEquals("Cameras",topMenu.get(6).getText());
  //    Assert.assertEquals("MP3 Players",topMenu.get(7).getText());

  //    for (WebElement menu : topMenu) {
  //        Assert.assertTrue(menu.isDisplayed());
  //    }
  //    //2.yöntem
         List<String> menuNames = new ArrayList<>();
         menuNames.add("Desktops");
         menuNames.add("Laptops & Notebooks");
         menuNames.add("Components");
         menuNames.add("Tablets");
         menuNames.add("Software");
         menuNames.add("Phones & PDAs");
        menuNames.add("Cameras");
        menuNames.add("MP3 Players");

        /**Utils paketinde bir tane Tools isimli class açtım.
         * 2 tane listeyi karşılaştıracağım için pratik olsun diye orada metod oluşturup kullandım..*/
        Tools.compareToList(menuNames,topMenu);


    }











}
