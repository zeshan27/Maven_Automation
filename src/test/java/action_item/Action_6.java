package action_item;

import Resuable_Classes.Reusable_method;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Action_6 {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException {



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
        for(int i = 1; i < rowCount; i++) {

            String purchasePrice = writableSheet.getCell(0, i).getContents();
            String dPayment = writableSheet.getCell(1, i).getContents();
            String mTerm = writableSheet.getCell(2, i).getContents();
            String iRate = writableSheet.getCell(3, i).getContents();
            String sMonth = writableSheet.getCell(4, i).getContents();
            String sYear = writableSheet.getCell(5, i).getContents();

            //navigate to mlcalc
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








        }//end loop

        driver.quit();

    }//end main



}//end class
