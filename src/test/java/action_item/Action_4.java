package action_item;

import Resuable_Classes.Reusable_method;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;

public class Action_4{
    public static void main(String[] args) throws InterruptedException {

        //set up driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options_ = new ChromeOptions();
        options_.addArguments("start-maximized");

        WebDriver driver_ = new ChromeDriver(options_);
        ArrayList<String> fName = new ArrayList<>();
        fName.add("Bob");
        fName.add("Billy");
        fName.add("James");

        ArrayList<String> lName = new ArrayList<>();
        lName.add("Roberts");
        lName.add("Bill");
        lName.add("James");

        ArrayList<String> dob = new ArrayList<>();
        dob.add("01011990");
        dob.add("02011990");
        dob.add("03011990");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11219");
        zipCode.add("11220");
        zipCode.add("11221");

        ArrayList<String> planID = new ArrayList<>();
        planID.add("112201");
        planID.add("112202");
        planID.add("112203");

        for(int i = 0; i<fName.size(); i++){
            driver_.navigate().to("https://www.uhc.com"); // Step 1 navigate to uhc.com
            Thread.sleep(1500);
            Actions mouse_ = new Actions(driver_);

            try {
                WebElement find_a_doctor = driver_.findElement(By.xpath("//a[text()='Find a doctor']")); // Step 2 click on find a doctor
                mouse_.moveToElement(find_a_doctor).click().perform();
                Thread.sleep(10000);
            }catch (Exception err){
                System.out.println("Find a doctor was not found " + err + "\n");
                //continue;


            }

            try{
                Thread.sleep(6000);
                WebElement pop_up_close_ = driver_.findElement(By.xpath("//strong[text()='NO']"));
                mouse_.moveToElement(pop_up_close_).click().perform();
                Thread.sleep(1500);
            }catch (Exception err){
                System.out.print("No popup " + err + "\n");
            }

            JavascriptExecutor jse = (JavascriptExecutor) driver_;
            jse.executeScript("scroll(0,3500)");

            //break;

            // Step 4 choose Medicaid plan from the sign in dropdown(see if you can use select command.
            // If not then click on dropdown then click on value by text)
            try {
                WebElement select_= driver_.findElement(By.xpath("//button[contains(text(),'Select your plan to sign in')]"));
                mouse_.moveToElement(select_).click().perform();
                WebElement medicare_plan_ = driver_.findElement(By.xpath("//a[text()='Medicare plan']"));
                mouse_.moveToElement(medicare_plan_).click().perform();
                Thread.sleep(5000);
            }catch (Exception err){
                System.out.println("Select your plan to sign in was not found " + err + "\n");
                //continue;
            }

            ArrayList<String> tabs = new ArrayList<>(driver_.getWindowHandles()); // store tabs in array current tabs 2

            try{ // Step 5 switch to the new tab
                driver_.switchTo().window(tabs.get(1)); // switch control to second tab
                Thread.sleep(2000);
            }catch (Exception err){
                System.out.println("Second tab was not found " + err + "\n");
                //continue;
            }

            try{ // Step 6 click on register now
                WebElement register_ = driver_.findElement(By.xpath("//button[contains(text(),'Register Now')]"));
                mouse_.moveToElement(register_).click().perform();
                Thread.sleep(2000);

            }catch (Exception err){
                System.out.println("Click on register now was not found " + err + "\n");
                //continue;
            }


            try{ // Step 7-11 enter data
                WebElement fname_ = driver_.findElement(By.xpath("//input[@id='piFirstName']"));
                fname_.sendKeys(fName.get(i));
                //mouse_.moveToElement(fname_).sendKeys(fName.get(i)).perform();
                WebElement lname_ = driver_.findElement(By.xpath("//input[@id='piLastName']"));
                lname_.sendKeys(lName.get(i));
                //mouse_.moveToElement(lname_).sendKeys(lName.get(i)).perform();
                WebElement dob_ = driver_.findElement(By.xpath("//input[@name='dob']"));
                dob_.sendKeys(dob.get(i));
                //mouse_.moveToElement(dob_).sendKeys(dob.get(i)).perform();
                WebElement zipCode_ = driver_.findElement(By.xpath("//input[@id='piZipCode']"));
                zipCode_.sendKeys(zipCode.get(i));
                //mouse_.moveToElement(zipCode_).sendKeys(zipCode.get(i)).perform();
                WebElement planID_ = driver_.findElement(By.xpath("//input[@id='piMemberId4Mnr']"));
                planID_.sendKeys(planID.get(i));
                //mouse_.moveToElement(planID_).sendKeys(planID.get(i)).perform();
                Thread.sleep(3000);
            }catch (Exception err){
                System.out.println("Data fields were not found " + err + "\n");
                //continue;
            }

            try{ // Step 12 click on continue
                WebElement continue_ = driver_.findElement(By.xpath("//button[@id='step1Btn']"));
                mouse_.moveToElement(continue_).click().perform();
                Thread.sleep(2000);
            }catch (Exception err){
                System.out.println("Continue was not found " + err + "\n");
                //continue;
            }

            try{ // Step 13 capture the error message and print it out
                String error1_ = driver_.findElement(By.xpath("//span[@class='error strong ng-binding']")).getText();
                String error2_ = driver_.findElement(By.xpath("//span[@class='ng-scope']")).getText();
                String error3_ = driver_.findElement(By.xpath("//p[@class='milli ng-binding']")).getText();
                System.out.println(error1_+" "+error2_+" "+error3_+ "\n");

            }catch(Exception err){
                System.out.println("No error message captured " + err + "\n" );
            }

            //break;
            Thread.sleep(3000);
            driver_.close(); // close current tab
            driver_.switchTo().window(tabs.get(0)); // change control to first tab
        }



        driver_.quit(); // close browser

    }
}

