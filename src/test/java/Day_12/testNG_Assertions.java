package Day_12;

import Resuable_Classes.Reusable_method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class testNG_Assertions {

    WebDriver driver;
     @BeforeSuite

     public void  setDriver() throws IOException {
         driver = Reusable_method.setDriver();


     }//end of test

    @Test

    public void testScenerio () throws InterruptedException {

         driver.navigate().to("https://www.google.com");

         Thread.sleep(2500);

         //verify the tittle says google
        Assert.assertEquals("G0oogle",driver.getTitle());

        //click on gmail

        Reusable_method.clickMethod(driver,"//*[@class='gb_f']","Gmail");
    }

}//end class
