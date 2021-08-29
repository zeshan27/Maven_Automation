package Resuable_Classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Reusable_method {

//method to declare and define chrome driver


    //method to declare and define a chrome driver
    public static WebDriver setDriver() throws IOException {
        //killing all the chrome instance that you have opened
        //Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
        //setup your driver
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        //options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of set driver method

    //clear and enter a value using sendKeys
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Entering a value on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to enter a value on " + elementName);
        }
    }//end of sendKeysMethod

    //click on element
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception err) {
            System.out.println("Unable to click on " + elementName);
        }
    }//end of clickMethod

    //submit on element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Submitting on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on " + elementName);
        }
    }//end of submitMethod

    //Get Text Method

    public static String getText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Result = element.getText();
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
        }
        return Result;

    }//End Of Get Text Method



    public static String getTextByIndex(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            Result = element.getText();
            System.out.println("Result is " + Result);
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
        }
        return Result;

    }//end of getTextByindex

    public static void selectMethod(WebDriver driver, String xpath, String choice, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Selecting from dropdown menu " + elementName);
            //define object for the dropdown WebElement
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            //define object for selection and pass it the dropdown object
            Select choiceSelect = new Select(element);
            //use selectByVisbibleText method on to the selection object and pass it the choice
            choiceSelect.selectByVisibleText(choice);
        } catch (Exception err) {
            System.out.println("Unable to select from " + elementName + " " + err);
        }//end of try catch
    }//end of selectMethod


    //HOVER
    public static void hovermouse(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        Actions mouseaction = new Actions(driver);
        try {
            System.out.println(" Hovering over" + elementName);
            WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseaction.moveToElement(element).perform();
        }
        catch (Exception err) {
            System.out.println("Unable to hover over " + elementName);
        }
    }//end of hovermouse


    //hover over an element
    public static void mouseHoverbyindex (WebDriver driver,String xpath,int index,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Hovering on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            actions.moveToElement(element).perform();
        } catch (Exception err) {
            System.out.println("Unable to hover on " + elementName);
        }
    }//end of hover method

    //click on pop up element
    public static void clickIfPopupExist(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,5);
        try{
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception err) {
            System.out.println("Popup didn't appear...Proceed to next step");
        }
    }//end of clickIfPopupExist

    //scroll to element
    public static void scrolltoelement(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,5);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            System.out.println("Scrolling to " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("element.scrolltoview(true)");
        } catch (Exception err) {
            System.out.println("can scroll  element not found");
        }
    }//end of scroll to element




}//end of class



