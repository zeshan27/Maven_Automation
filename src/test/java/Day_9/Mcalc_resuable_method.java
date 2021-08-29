package Day_9;

import Resuable_Classes.Reusable_method;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.Driver;

public class Mcalc_resuable_method {


    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = Reusable_method.setDriver();

        //navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com ");

        Thread.sleep(2500);
        //clear and enter a purchase price
        Reusable_method.sendKeysMethod(driver, "//*[@id='ma']", "400000", "Purchase Price");
        //clear and enter down paymentReusable_method.sendKeysMethod(driver,"//*[@id='dp']","25","Down Payment");
    }//main method

}//end class

