package Day_4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search {
    public static void main(String[] args) throws InterruptedException {

        //set property and path to your chromedriver

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the chrome driver basically what driver  i am using for automation

        WebDriver driver = new ChromeDriver();

        //navigate to google search page

        driver.navigate().to("https://www.google.com");

        //maximize the window
        driver.manage().window().maximize();

        //sleep
        Thread.sleep(3000);

        // Identify the search feild and enter the key word cars

        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");


//submiting search

        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //sleep
        Thread.sleep(3000);

        //capture results

       String result =  driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

//print result

        //System.out.println(result);


        // extract numbers using split

        String[] arrayResult = result.split(" ");
        System.out.println("This shit" + arrayResult[1]);
        //close drive
        driver.close();



    }//end of main

}//end of class

