package Gun03;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
 */
public class _02_AddressFunctionality extends GenelWebDriver {

    By link=By.xpath("//div[@id=\"content\"]//a[text()='Address Book']");
    By button=By.xpath("//a[text()='New Address']");

    By firstName=By.xpath("//input[@name=\"firstname\"]");
    By lastName=By.xpath("//input[@name=\"lastname\"]");
    By company=By.xpath("//input[@name=\"company\"]");
    By address_1=By.xpath("//input[@name=\"address_1\"]");
    By address_2=By.xpath("//input[@name=\"address_2\"]");
    By city=By.xpath("//input[@name=\"city\"]");
    By postcode=By.xpath("//input[@name=\"postcode\"]");

    By defaultAddressYes=By.xpath("//input[@value=\"1\"]");
    By defaultAddressNo=By.xpath("//input[@value=\"0\"]");

    By continueButton=By.xpath("//input[@type=\"submit\"]");

    By edit=By.xpath("//a[text()='Edit']");

    By delete=By.xpath("//a[text()='Delete']");


    @Test
    void addAddress(){


        WebElement addressBookLink=driver.findElement(link);
        addressBookLink.click();

        WebElement newAddressButton=driver.findElement(button);
        newAddressButton.click();

        WebElement firstNameBoxInput=driver.findElement(firstName);
        firstNameBoxInput.sendKeys("Fener");

        WebElement lastNameBoxInput=driver.findElement(lastName);
        lastNameBoxInput.sendKeys("Bahçe");

        WebElement companyInput=driver.findElement(company);
        companyInput.sendKeys("Fenerbahçe Spor Kulübü");

        WebElement address1Input=driver.findElement(address_1);
        address1Input.sendKeys("Şükrü Saracoğlu Stadyumu, Bağdat Cad, Kızıltoprak, No:2, 34724 Kadıköy/İstanbul");

        WebElement address2Input=driver.findElement(address_2);
        address2Input.sendKeys("Şükrü Saracoğlu Stadyumu, Bağdat Cad, Kızıltoprak, No:2, 34724 Kadıköy/İstanbul");

        WebElement cityInput=driver.findElement(city);
        cityInput.sendKeys("İstanbul");

        WebElement postcodeInput=driver.findElement(postcode);
        postcodeInput.sendKeys("34724");


        WebElement country=driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
        Select countries=new Select(country);
        //wait.until(ExpectedConditions.stalenessOf(country));  -----> bayat eleman gidene kadar bekle (ülke seçildikten sonra yeni elemana dönüşür (stale element hatası olmaz))
        wait.until(ExpectedConditions.elementToBeClickable(country));
        countries.selectByValue("215");


        WebElement region=driver.findElement(By.xpath("//select[@name=\"zone_id\"]"));
        Select regions=new Select(region);
        //wait.until(ExpectedConditions.stalenessOf(region));    ----> bayat eleman gidene kadar bekle (yukarıda seçilen ülkeye ait şehirler yüklendiğinde yeni elemana dönüşür (stale element hatası olmaz))
        wait.until(ExpectedConditions.elementToBeClickable(region));
        regions.selectByValue("3354");

        WebElement defaultAddress=driver.findElement(defaultAddressNo);
        defaultAddress.click();

        WebElement continueBtn=driver.findElement(continueButton);
        continueBtn.click();

        Tools.successMessageValidation();
    }


    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddresses(){

        List<WebElement> deleteButtons=driver.findElements(By.xpath("//a[text()='Delete']"));

        List<WebElement> editButtons=driver.findElements(By.xpath("//a[text()='Edit']"));
        for (int i = 0; i < editButtons.size(); i++) {
            List<WebElement> editButtons1=driver.findElements(By.xpath("//a[text()='Edit']"));
//            List<WebElement> editButtons1=driver.findElements(By.xpath("//a[text()='Edit']"));
            editButtons1.get(i).click();

            WebElement defaultAddress=driver.findElement(defaultAddressNo);

            WebElement backButton=driver.findElement(By.xpath("//a[text()='Back']"));

            if (defaultAddress.isSelected()){
                backButton.click();
                List<WebElement> deleteButtons1=driver.findElements(By.xpath("//a[text()='Delete']"));
                deleteButtons1.get(i).click();
            }else{
                backButton.click();
            }
        }



    }


  @Test(dependsOnMethods = {"addAddress"})
  void editAddress(){
      WebElement editButton=driver.findElement(edit);
      editButton.click();

      WebElement firstNameBoxInput=driver.findElement(firstName);
      firstNameBoxInput.clear();
      firstNameBoxInput.sendKeys("Akın");

      WebElement lastNameBoxInput=driver.findElement(lastName);
      lastNameBoxInput.clear();
      lastNameBoxInput.sendKeys("Daşkapan");

      WebElement country=driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
      Select countries=new Select(country);
      wait.until(ExpectedConditions.elementToBeClickable(country));
      countries.selectByValue("215");


      WebElement region=driver.findElement(By.xpath("//select[@name=\"zone_id\"]"));
      Select regions=new Select(region);
      wait.until(ExpectedConditions.elementToBeClickable(region));
      regions.selectByValue("3354");


      WebElement defaultAddress=driver.findElement(defaultAddressNo);
      defaultAddress.click();

      WebElement continueBtn=driver.findElement(continueButton);
       continueBtn.click();

       Tools.successMessageValidation();
   }

}
