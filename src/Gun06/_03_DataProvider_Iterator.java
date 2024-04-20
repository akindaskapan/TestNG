package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    /** EĞER ELİMİZDE LIST VARSA AŞAĞIDAKİ ŞEKİLDE YAPABİLİRİZ.*/

    @Test(dataProvider = "getData")
    void usernameTest(String username){
        System.out.println("Kullanıcı adı = "+ username);
    }


    @DataProvider
    public Iterator<Object> getData(){

        List<Object> data=new ArrayList<>();
        data.add("Akın");
        data.add("Fener");
        data.add("Bahçe");
        data.add("Kanarya");

        return data.iterator();
    }


    /********************************************************* 2 BOYUTLU HALİ***************************************************************/


    @Test(dataProvider = "getData2")
    void usernameTest2(String username, String password){
        System.out.println("Kullanıcı adı = "+ username+" , "+"Şifre = "+password);
    }


    @DataProvider
    public Iterator<Object[]> getData2(){

        List<Object[]> data=new ArrayList<>();
        data.add(new Object[]{"Akın","şifre1111"});
        data.add(new Object[]{"Fener","şifre2222"});
        data.add(new Object[]{"Bahçe","şifre3333"});
        data.add(new Object[]{"Kanarya","şifre4444"});

        return data.iterator();
    }





}
