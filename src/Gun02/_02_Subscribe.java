package Gun02;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
        Senaryo;
        1- Siteyi açınız
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.
        3-İsimlerinin sıralı olduğunu doğrulayınız.
     */
public class _02_Subscribe extends GenelWebDriver {

    @Test(priority = 1)
    void subscribe() {
        WebElement newsletterLink = driver.findElement(By.xpath("//div[@id=\"content\"]//a[text()='Newsletter']"));
        newsletterLink.click();
        WebElement yesButton = driver.findElement(By.xpath("//input[@value=\"1\"]"));
        yesButton.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        continueButton.click();

        WebElement subscribedText = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
        Assert.assertEquals(subscribedText.getText(), "Success: Your newsletter subscription has been successfully updated!");
    }

  @Test(priority = 2)
  void unSubscribe(){
      WebElement newsletterLink = driver.findElement(By.xpath("//div[@id=\"content\"]//a[text()='Newsletter']"));
      newsletterLink.click();
      WebElement noButton = driver.findElement(By.xpath("//input[@value=\"0\"]"));
      noButton.click();

      WebElement continueButton = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
      continueButton.click();

      WebElement subscribedText = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
      Assert.assertEquals(subscribedText.getText(), "Success: Your newsletter subscription has been successfully updated!");
  }






}
