package Gun01;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
   Senaryo ;
     1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- fenerbaba@hotmail.com  ve akinbaba bilgileri ile login olan test metodunu yazınız.
     3- Login olup olmadığınızı assert ile kontrol ediniz.

 */

public class _05_Ornek extends GenelWebDriver {

    @Test
    void loginTest(){


        WebElement inputMail=driver.findElement(By.xpath("//input[@name=\"email\"]"));
        inputMail.sendKeys("fenerbaba@hotmail.com");
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name=\"password\"]"));
        inputPassword.sendKeys("akinbaba");

        WebElement loginButton=driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginButton.click();




    }


}
