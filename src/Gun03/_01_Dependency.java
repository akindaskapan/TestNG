package Gun03;

/*
Interviewlarda sorulan bir konu: testlere öncelikleri nasıl verirsin ?
priority, dependency: Nasıl kullanırsın ?
1-priority = 1 gibi sıralı sayılar vererek çalışma sırasını belirtirim.
2-dependency yöntemi (dependOnMethods): bununla kendinden önce hangi metodun çalışması gerekiyor ise onu belirtirim.

      metodları tek tek çalıştırırken kendinden önce bağımlı 1  metod var ise ototmaitk onları
      önce çağırıp sonra kendisi çalışır. Fakat 2 veya daha fazla tane var ise bağımlı olduğu metod ozaman çalışamaz.
 */



import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar(){
        System.out.println("Car started.");
    }

    @Test(dependsOnMethods = {"startCar"}) //yani bu testin çalışması startCar metodunun çalışmasına bağlı olsun dedim.
    void driveCar(){                      // startCar metodu düzgün çalışıp kapanmadan bu metod çalışmasın
        System.out.println("Car driving.");
        //Assert.fail();//bilerek fail verdirttim. eğer bu metod çalışmazsa ne olacağını görmek için
    }

    @Test(dependsOnMethods = {"startCar","driveCar"}) //bu testin çalışması için verilen 2 metodun da çalışıp bitmesi lazım.
    void parkCar(){
        System.out.println("Car parked.");
    }

    @Test(dependsOnMethods = {"parkCar"},alwaysRun = true )/*DİĞER METODLAR ÇALIŞSA DA ÇALIŞMASA DA BURASI ÇALIŞSIN DEMEK İSTEDİM*/
    void stopCar(){
        System.out.println("Car Stopped.");
    }





}
