package Day_11;

import Resuable_Classes.Reusable_method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class Topic_1 {

    WebDriver driver;

    @BeforeSuite
    public void setTheChromeDriver() throws IOException, IOException {
        driver = Reusable_method.setDriver();
    }//end of before suite

    @Test(priority = 1)
    public void searchForCar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Reusable_method.sendKeysMethod(driver,"//*[@name='q']","cars","Search Field");
        Reusable_method.submitMethod(driver,"//*[@name='btnK']","Search Button");
        Thread.sleep(2500);
    }//end of test 1

    @Test(dependsOnMethods = "searchForCar")
    public void captureTheSearchNumber(){
        //capture the search result content
        String result = Reusable_method.getText(driver,"//*[@id='result-stats']","Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("search number is " + arrayResult[1]);
    }//end of test 2

    @AfterSuite
    public void closeTheDriver(){
        driver.quit();
    }//end of after suite
}
