package Day_10;

import Resuable_Classes.Reusable_method;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class mcacl_data_driver {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {


        //step 1: locate the file path where you saved it
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Mort_Calc.xls"));
//create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_datadriven_results.xls"),readableFile);
//Step 2: accessing the excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);
//Step 3: row count will return all the rows which is not empty
        int rowCount = writableSheet.getRows();

//set the driver
        WebDriver driver = Reusable_method.setDriver();

//call the for loop to iterate through your test data from excel
        for(int i = 1; i < rowCount; i++){

            String purchasePrice = writableSheet.getCell(0,i).getContents();
            String dPayment = writableSheet.getCell(1,i).getContents();
            String mTerm = writableSheet.getCell(2,i).getContents();
            String iRate = writableSheet.getCell(3,i).getContents();
            String sMonth = writableSheet.getCell(4,i).getContents();
            String sYear = writableSheet.getCell(5,i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2500);
            //enter the purchase price
            Reusable_method.sendKeysMethod(driver,"//*[@id='ma']",purchasePrice,"Purchase Price");
            //enter the down payment
            Reusable_method.sendKeysMethod(driver,"//*[@id='dp']",dPayment,"Down Payment");
            //enter the mortgage term
            Reusable_method.sendKeysMethod(driver,"//*[@id=mt']",mTerm,"Mortagage Term");
            //enter the interest rate
            Reusable_method.sendKeysMethod(driver,"//*[@id='ir']",iRate,"Interesr Rate");
            //click on show advance options
            Reusable_method.clickMethod(driver,"//*[text()='Show advanced options']","Show Advance Options");
            //select the start month
            Reusable_method.selectMethod(driver,"//*[@name='sm']",sMonth,"Start Month");
            //select the start year
            Reusable_method.selectMethod(driver,"//*[@name='sy']",sYear,"Start Year");
            //click on calculate
            Reusable_method.clickMethod(driver,"//*[@value='Calculate']","Calculate");

            //capture the monthly payment and send it back to writable excel sheet
            String result = Reusable_method.getText(driver,"//div[text()='Monthly Payment']/preceding::div","Monthly Payment");

    }//end of for loop

    //write back to excel
        writableFile.write();
    //close the file
        writableFile.close();

    //outside of loop quit the driver

        driver.quit();



    }//end main
}//end class


