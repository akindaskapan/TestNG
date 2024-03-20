package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


/*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */
public class _03_EditAccount extends GenelWebDriver {

    By link =By.xpath("//div[@id=\"content\"]//a[text()='Edit Account']");
    By name= By.xpath("//input[@name=\"firstname\"]");
    By surname= By.xpath("//input[@name=\"lastname\"]");
    By continueButton=By.xpath("//input[@type=\"submit\"]");

@Test
    void editAccount(){
  //  WebElement editAccountLink=driver.findElement(link);
  //  editAccountLink.click();
//
  //  WebElement nameInput=driver.findElement(name);
  //  nameInput.clear();
  //  nameInput.sendKeys("AkınTest");
//
//
  //  WebElement surnameInput=driver.findElement(surname);
  //  surnameInput.clear();
  //  surnameInput.sendKeys("DaşkapanTest");
//
  //  WebElement cntBtn=driver.findElement(continueButton);
  //  cntBtn.click();
  //
  //  Tools.successMessageValidation();

    Tools.editAccount();
    Tools.successMessageValidation();
    Tools.editAccount();
    Tools.successMessageValidation();

}


}
