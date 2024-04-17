package Gun05;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
public class _02_ContactUs extends GenelWebDriver {

    //Test dinamik olsun ve her defasında farklı bir parametre girebileyim diye @Parameters'i kullandım. XML'de inceleyebilirsin.
@Test
@Parameters("mesaj") //XML'deki adı.
    void contactUs(String gelenMesaj)//metoddaki adı    (parametredeki ile buradaki aynı şey)
    {
        WebElement contactUs=driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUs.click();


        //bunları yorum satırına aldım cunku sıteyı acınca kendısı otomatık emaıl ve ısmı yazıyor
      //  WebElement nameInputBox=driver.findElement(By.xpath("//input[@id=\"input-name\"]"));
      //  nameInputBox.sendKeys("Akın Daşkapan");
//
      //  WebElement emailInputBox=driver.findElement(By.xpath("//input[@id=\"input-email\"]"));
      //  emailInputBox.sendKeys("akintest@hotmail.com");

        WebElement enquiryInputBox=driver.findElement(By.xpath("//textarea[@name=\"enquiry\"]"));
        enquiryInputBox.sendKeys(gelenMesaj);

        WebElement submitButton=driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        submitButton.click();

        WebElement contactUsText=driver.findElement(By.xpath("//h1[text()='Contact Us']"));
        System.out.println(contactUsText.getText());
        Assert.assertEquals("Contact Us",contactUsText.getText(),"Karşılaştırma sonucu.");


    }







}
