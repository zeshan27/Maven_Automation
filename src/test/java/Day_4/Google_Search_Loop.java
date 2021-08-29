package Day_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Google_Search_Loop {
    public static void main(String[] args) throws InterruptedException {

        String[] cities = new String[3];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";

//set the property and path to your chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//define the chrome driver basically what driver I am going to use for automation
        WebDriver driver = new ChromeDriver();


        for(int i = 0; i < cities.length; i++){
            //navigate to google search page
            driver.navigate().to("https://www.google.com");
            //maximize the browser
            //driver.manage().window().maximize();

            //put few seconds wait
            Thread.sleep(4000);

            //identify the search field and enter a keyword 'cars'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

            //hit submit on the search icon
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //every time you interact with a new page you should put sleep statement
            Thread.sleep(2000);

            //capture the search result and only print out the number
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();


            //extract out the number from the search result and print it using split
            String[] arrayResult = result.split(" ");
            System.out.println("My search number for city " + cities[i] + " is " + arrayResult[1]);

        }//end of loop

        driver.quit();



    }//End of main
}//end of class



