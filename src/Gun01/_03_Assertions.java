package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {
                                                                /**ÖN BİLGİ
                                                                 * EĞER KODLARIN ICERSINDE HATALI BIR ASSERTION VARSA O KOD CALISMAZ VE SARI ÇARPI GÖRÜNÜR(ÇALIŞMADIĞINI GOSTERMEK ICIN)
                                                                *AŞAĞIDAKİLERİ YAZMAMIN SEBEBİ : DOĞRU VE YANLIŞ ASSERTION'DA NE OLDUGUNU GORMEK ICIN*/
    //Yeşil tik : testte hata yok
    //Sarı çarpı : testte hata var
    //Beyaz : test çalıştırılmadı, skip
    @Test
    void equalOrnek(){
        String s1="Merhaba";
        String s2="İyi akşamlar";

        //oluşan(s1),beklenen(s2), "hata başlığı"
        Assert.assertEquals(s1,s2,"Karşılaştırma sonucu");
        //Actual : oluşan
        //Expected : beklenen

        /** BURADA ASSERTİ BİLEREK YANLIŞ YAPTIM CUNKU CALISTIRDIGIMDA ASAGIDA HATA OLDUGUNU GÖSTEREN "SARI ÇARPI"'YI GORMEK ICIN */
    }


    @Test
    void notEqualOrnek(){
        String s1="Merhaba";
        String s2="İyi akşamlar";
        Assert.assertNotEquals(s1,s2,"Karşılaştırma sonucu");
    }

    @Test
    void trueOrnek(){
        int s1=55;
        int s2=55;

        Assert.assertTrue(s1==s2,"Karşılaştırma sonucu");
    }


 @Test
 void nullOrnek(){
        String s1=null;
        Assert.assertNull(s1,"Karşılaştırma sonucu");
 }

    @Test
    void direktFail(){//falan filan koşul olursa fail verdirmek için de kullanılır
        int a=55;
        if (a==5)
        Assert.fail();
    }



}