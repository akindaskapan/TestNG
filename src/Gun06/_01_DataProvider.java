package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    /**
     * Aşağıdaki ikli ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılı, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     * * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     * XML filer file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */

    @Test(dataProvider = "getData")//                          -------> dataProvider annotation'u veriyi aşağıdaki getData isimli metoddan alsın dedim.
    void usernameTest(String username){
        System.out.println("Kullanıcı adı = "+ username);
    }


    @DataProvider// bu metoda dataprovider görevi verildi.
    public Object[] getData(){// DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.

        Object[] data={"Akın","Fener","Bahçe","Kanarya"};

        return data;
    }

    /************************************************* FARKLI BİR EŞLEŞTİRME YÖNTEMİ *******************************************************/

    @Test(dataProvider = "users") // DataProviderın ismi burda metod adı yerine kullanıldı.               -------> dataProvider annotation'u veriyi aşağıdaki metoddan alsın dedim.
    void usernameTest2(String username){
        System.out.println("Kullanıcı adı2 = "+ username);
    }

    @DataProvider(name = "users")// DataProvider a isim verdim.            -------> verilerin olduğu metod
    public Object[] getData2() {// DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.


        Object[] data = {"Travis", "Scott", "NLE", "Choppa"};

        return data;
    }

}
