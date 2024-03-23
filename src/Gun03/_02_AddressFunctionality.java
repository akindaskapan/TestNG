package Gun03;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3-
       4-
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

    By continueButton=By.xpath("//input[@type=\"submit\"]");




    @Test
    void addAddress(){
        WebElement addressBookLink=driver.findElement(link);
        addressBookLink.click();

        WebElement newAddressButton=driver.findElement(button);
        newAddressButton.click();

        WebElement firstNameBoxInput=driver.findElement(firstName);
        firstNameBoxInput.sendKeys("Akın");

        WebElement lastNameBoxInput=driver.findElement(lastName);
        lastNameBoxInput.sendKeys("Daşkapan");

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

        bekle(3);


        WebElement country=driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
        Select countries=new Select(country);
        wait.until(ExpectedConditions.elementToBeClickable(country));
        //countries.selectByValue("215");
        countries.selectByIndex(10);
        bekle(3);


        WebElement region=driver.findElement(By.xpath("//select[@name=\"zone_id\"]"));
        Select regions=new Select(region);
        wait.until(ExpectedConditions.elementToBeClickable(region));
        //regions.selectByValue("3354");
        regions.selectByIndex(3);
        bekle(3);

        WebElement defaultAddress=driver.findElement(defaultAddressYes);
        defaultAddress.click();

        WebElement continueBtn=driver.findElement(continueButton);
        continueBtn.click();

        bekle(40);


    }




}
