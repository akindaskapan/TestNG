package Gun01;


import org.testng.annotations.Test;

public class _01_Giris  {

    /**Önceden main açıp komutları yazmak gerekiyordu ama burada main yazmaya gerek yok tek tek test oluşturabiliyoruz*/

    //    public static void main(String[] args) {
//        webSitesiniAc();
//        LoginTestIsleminiYap();
//        driverıKapat();
//    }

    //eğer test metodlarına sıralama(priority) verilmezse alfabetik sıraya göre çalışır.

    //eğer hatalı assertion yoksa run kısmında yeşil tikler olur.


@Test(priority = 1)// bu kısmın adı annotation (türkçesi dipnot demek. nasıl çalışması gerektiğini bu kısma yazıyoruz)
    void webSitesiniAc(){
        System.out.println("Driver tanımlandı ve web sitesi açıldı.");
    }
    @Test(priority = 2)//priority = öncelik sırası
    void logInIsleminiYap(){
        System.out.println("Login test işlemleri yapıldı.");
    }

@Test(priority = 3)
    void driveriKapat(){
        System.out.println("Driver kapatıldı ve ve çıkıldı.");
    }









}
