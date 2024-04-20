package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {



    @Test(dataProvider = "getData")
    void usernameTest(String username,String password){
        System.out.println("Kullanıcı adı = "+ username+" , "+"Şifre = " + password);
    }


    @DataProvider
    public Object[][] getData(){

        Object[][] data={
                {"Akın","sifre11111"},
                {"Fener","sifre22222"},
                {"Bahçe","sifre33333"},
                {"Kanarya","sifre44444"}
        };

        return data;
    }

}
