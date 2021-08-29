package action_item;

import Resuable_Classes.Reusable_method;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.express.com");
        driver.manage().window().maximize();
        Thread.sleep(2500);

        //close popup
        Reusable_method.clickMethod(driver,"//*[@id='closeModal']","");
        //hovermosue
        Reusable_method.hovermouse(driver,"//a[text()='Men']","Man tag");
        //pause
        Thread.sleep(3000);
        //Click Polo
        Reusable_method.clickMethod(driver,"//a[text()='Polos']","Polo");
        //pause
        Thread.sleep(5000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("//h1[text()='Men's Polos']");

        //pause
        Thread.sleep(5000);








        //Reusable_method.hovermouse(driver,"//*[@id='Oval-7']","");

        //Thread.sleep(5000);


        //Quit

        driver.quit();








    }//end main
}//end class
