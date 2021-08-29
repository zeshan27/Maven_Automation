package action_item;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action_2 {
    public static void main(String[] args) throws InterruptedException {
        String [] Country = new String[4];

        Country [0] = "Dubai";
        Country [1] = "Turkey";
        Country [2] = "Canada";
        Country [3] = "Pakistan";

        //set the property and path to your chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//define the chrome driver basically what driver I am going to use for automation
        WebDriver drv = new ChromeDriver();


        for(int i = 0; i < Country.length; i++) {

            drv.navigate().to("https://www.bing.com");

            drv.manage().window().maximize();

            Thread.sleep(5000);

            drv.findElement(By.xpath("//*[@name='q']")).sendKeys(Country[i]);
            drv.findElement(By.xpath("//*[@id='sb_form_q']")).submit();

            Thread.sleep(5000);

            String  result = drv.findElement(By.xpath("//*[@class='sb_count']")).getText();

            Thread.sleep(2000);

           String [] arrayResult = result.split(" ");

            System.out.println("The Search results for " + Country[i] + "are " + arrayResult[i]);

        }//end loop

        drv.quit();


    }//end of main

}//end of class
