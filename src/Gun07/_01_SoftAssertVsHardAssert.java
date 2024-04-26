package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

@Test
    void hardAssert(){
        String s1="Merhaba";

    System.out.println("hard assert öncesi");
    Assert.assertEquals("Merhaba 123","HardAssert Sonucu");
    System.out.println("hard assert sonrası");
    }


    @Test
    void softAssert(){
    String strHomePage="www.facebook.com/homepage";
    String strCartPage="www.facebook.com/cartpage";
    String strEditAccountPage="www.facebook.com/editaccountpage";


        SoftAssert _softAssert=new SoftAssert();
        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage); //true
        System.out.println("assert 1");

        _softAssert.assertEquals("www.facebook.com/profile",strHomePage); //fail
        System.out.println("assert 2");

        _softAssert.assertEquals("www.facebook.com/settings",strEditAccountPage); //fail
        System.out.println("assert 3");

        _softAssert.assertAll();//bütün assert sonuçlarını topluyor.
        System.out.println("aktiflik sonrası");//bu bölüm assertAll'dan sonra olduğu için ve öncesinde hata oluştuğu için yazılamadı.

    }





}
