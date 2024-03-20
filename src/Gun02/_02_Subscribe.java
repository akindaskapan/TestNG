package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız

     */
public class  _02_Subscribe extends GenelWebDriver {
    By newsletterLink =By.xpath("//div[@id=\"content\"]//a[text()='Newsletter']");
    By yesButton =By.xpath("//input[@value=\"1\"]");

    By noButton=By.xpath("//input[@value=\"0\"]");
    By continueButton=By.xpath("//input[@value=\"Continue\"]");



    @Test(priority = 1)
    void subscribe() {
        WebElement link = driver.findElement(newsletterLink);
        link.click();
        WebElement yes = driver.findElement(yesButton);
        yes.click();

        WebElement continueBtn = driver.findElement(continueButton);
        continueBtn.click();

        //bu yazı çıktı mı diye doğrulatıyorum. bu işlemi daha sonra bir daha yapmam gerekirse diye bunun metodunu Tools class'ında oluşturup, oradan kullanacam.
        //WebElement subscribedText = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
        //Assert.assertTrue(subscribedText.getText().contains("Success"));
        Tools.successMessageValidation();
    }

  @Test(priority = 2)
  void unSubscribe(){
      WebElement link = driver.findElement(newsletterLink);
      link.click();

      WebElement no = driver.findElement(noButton);
      no.click();

      WebElement continueBtn = driver.findElement(continueButton);
      continueBtn.click();

      //bu yazı çıktı mı diye doğrulatıyorum. bu işlemi daha sonra bir daha yapmam gerekirse diye bunun metodunu Tools class'ında oluşturup, oradan kullanacam.
      //WebElement subscribedText = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
      //Assert.assertEquals(subscribedText.getText(), "Success: Your newsletter subscription has been successfully updated!");
      Tools.successMessageValidation();
  }


  @Test(priority = 3)
    void changeSelection(){

      WebElement link = driver.findElement(newsletterLink);
      link.click();


 WebElement yesTiki=driver.findElement(yesButton);
 WebElement noTiki=driver.findElement(noButton);

        if (yesTiki.isSelected()){
            noTiki.click();
        }


        if (noTiki.isSelected()){
            yesTiki.click();
        }

      WebElement continueBtn = driver.findElement(continueButton);
      continueBtn.click();


      Tools.successMessageValidation();




  }




}
