package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Tools {


    //2 tane listi karşılaştırmak için yapıyorum bu methodu. 2 listi karşılaştırmam gereken yerlerde buradan direkt çağırabilecem.
public static void compareToList(List<String> exoectedList, List<WebElement> actualList){
    for (int i = 0; i < exoectedList.size(); i++) {

        //Assert.assertEquals(exoectedList.get(i),actualList.get(i).getText());
        Assert.assertEquals("Karşılaştırma hatası",exoectedList.get(i),actualList.get(i).getText());
    }

}


}
