package Gun1;

import org.testng.annotations.*;

public class _02_Annotations {

    /*
    @BeforeClass --> // Her class çalışıyorken önce burası çalışır.
        @BeforeMethod --> //Her metoddan(yani testten) önce çalışır.
            @Test --> //Testlerin çalıştığı metodlar.
            @Test --> //Testlerin çalıştığı metodlar.
        @AfterMethod --> //Her metoddan(yani testten) sonra çalışır.
    @AfterClass --> // Her class çalışıyorken sonra burası çalışır.
     */

    @BeforeClass
    void beforeClass(){
        System.out.println("Her classtan önce çalışacak : Before Class");
    }

@BeforeMethod
    void beforeMethod(){
        System.out.println("Her metoddan(yani testten) önce çalışacak : Before Method");
    }

@Test
    void test1(){
        System.out.println("Test1 çalıştı.");
    }

    @Test
    void test2(){
        System.out.println("Test2 çalıştı.");
    }

@AfterMethod
    void afterMethod(){
        System.out.println("Her metoddan(yani testten) sonra çalışacak : After Method");
    }

@AfterClass
    void afterClass(){
        System.out.println("Her classtan sonra çalışacak : After Class");
    }



                                                        /**ÖĞRENDİĞİM ŞEYLER ÖZET*/
                                                        /** classlardan ve metodlardan önce(testlerden önce ) çalışmasını istediğim şeyleri belirledim
                                                         * örneğin before class'a : driverı başlat yazabilirim
                                                         * after class'a : driverı kapat yazabilirim
                                                         * before method(test) kısmına : testten önce çalışacak şeyleri yazabilirim
                                                         * after method(test) kısmına : testten sonra çalışacak şeyleri yazabilirim**/

                                                        //yazdığım beformethod&aftermethod'lar her method için çalışır
    //kodları run ettiğinde zaten bunu gorebilirisn her metoddan once ve sonra belırledıgım şeyler yazıyor


}
