package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tools {


    //2 tane listi karşılaştırmak için yapıyorum bu methodu. 2 listi karşılaştırmam gereken yerlerde buradan direkt çağırabilecem.
public static void compareToList(List<String> exoectedList, List<WebElement> actualList){
    for (int i = 0; i < exoectedList.size(); i++) {

        //Assert.assertEquals(exoectedList.get(i),actualList.get(i).getText());
        Assert.assertEquals("Karşılaştırma hatası",exoectedList.get(i),actualList.get(i).getText());
    }

}

public static void successMessageValidation(){
    WebElement subscribedText = GenelWebDriver.driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
    Assert.assertTrue(subscribedText.getText().contains("success"));
}

    public static double WebElementStringToDouble(WebElement e) {
        String result=e.getText();
        result=result.replaceAll("[^\\d.,]",""); //nokta , virgül , ve sayı dışındaki tüm karakterleri temizle
        return Double.parseDouble(result);
    }

public static void editAccount(String ad , String soyad){

    By link =By.xpath("//div[@id=\"content\"]//a[text()='Edit Account']");
    By name= By.xpath("//input[@name=\"firstname\"]");
    By surname= By.xpath("//input[@name=\"lastname\"]");
    By continueButton=By.xpath("//input[@type=\"submit\"]");

    WebElement editAccountLink=GenelWebDriver.driver.findElement(link);
    editAccountLink.click();

    WebElement nameInput=GenelWebDriver.driver.findElement(name);
    nameInput.clear();
    nameInput.sendKeys(ad);


    WebElement surnameInput=GenelWebDriver.driver.findElement(surname);
    surnameInput.clear();
    surnameInput.sendKeys(soyad);

    WebElement cntBtn=GenelWebDriver.driver.findElement(continueButton);
    cntBtn.click();

    Tools.successMessageValidation();

    }

public static int randomGenerator(int max){
    return  (int) (Math.random() * max);
}



}
