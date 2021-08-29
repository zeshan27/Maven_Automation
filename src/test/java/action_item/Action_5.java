package action_item;

import Resuable_Classes.Reusable_method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;

public class Action_5 {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = Reusable_method.setDriver();


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

        for(int i = 0; i<fName.size(); i++) {
            driver.navigate().to("https://www.uhc.com"); // Step 1 navigate to uhc.com
            Thread.sleep(1500);
            Actions mouse_ = new Actions(driver);

            Reusable_method.clickMethod(driver, "//*[@class='position-relative bg-blueDark color-white display-block width-100 lg-bg-white p-4 size-17 talign-center']", "Find Doctor");

            Thread.sleep(3000);

            Reusable_method.clickMethod(driver, "//strong[text()='NO']", "");

            Reusable_method.clickMethod(driver, "//button[contains(text(),'Select your plan to sign in')]", "Plan");

            Reusable_method.clickMethod(driver, "//a[text()='Medicare plan']", "Medicare plan");



        }//end for loop
    }//end main




}//end class
