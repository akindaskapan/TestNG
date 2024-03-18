package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
        Senaryo;
        1- Siteyi açınız
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.
        3-İsimlerinin sıralı olduğunu doğrulayınız.
     */
public class _02_Subscribe extends GenelWebDriver {
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
}
