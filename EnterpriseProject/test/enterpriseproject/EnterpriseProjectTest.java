package enterpriseproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lee_c
 */
public class EnterpriseProjectTest {
    
    public static WebDriver driver;
    
    @BeforeClass
    public static void SetupTest(){
        System.setProperty("webdriver.chrome.driver", 
                "C:\\Users\\jardo\\!Selenium\\chromedriver.exe");
        System.out.println("Test initiated");
        driver = new ChromeDriver();
    }
    
    @AfterClass
    public static void TearDownTest(){
        driver.close();
    }
 
    
    public EnterpriseProjectTest() {
    }

    @Test
    public void scrapeData() {
        driver.get("https://li-public.fmcsa.dot.gov/LIVIEW/pkg_oos_process.prc_list?pv_vpath=LIVIEW&pv_show_all=N&pn_dotno=&pn_docket=&pv_legalname=&s_state=COUS");
        WebElement OOSTable = driver.findElement(By.xpath("/html/body/font/table[2]"));
        int rowNum = driver.findElements(By.xpath("/html/body/font/table[2]/tbody/tr")).size();
        System.out.println(rowNum+":6");
        List<WebElement> rowVals = OOSTable.findElements(By.tagName("tr"));       
        for(int i=1; i<rowNum; i++){
            List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("font"));
            TruckData data = new TruckData();
        for(int j=0; j<6; j++){           
                switch(j){
                    case 0:
                        data.setUSDOT(colVals.get(j).getText().replace("\n","").replace("\r",""));
                        System.out.println("USDot: "+data.getUSDOT());
                        break;
                    case 1:
                        data.setLegalName(colVals.get(j).getText().replace("\n","").replace("\r","").replace("'","''"));
                        System.out.println("Legal Name: "+data.getLegalName());
                        break;
                    case 2:
                        data.setAddress(colVals.get(j).getText().replace("\n","").replace("\r",""));
                        System.out.println("Address: "+data.getAddress());
                        break;
                    case 3:
                        data.setOOSReason(colVals.get(j).getText().replace("\n","").replace("\r",""));
                        System.out.println("OOS Reason: "+data.getOOSReason());
                        break;
                    case 4:
                        data.setOOSDate(colVals.get(j).getText().replace("\n","").replace("\r",""));
                        System.out.println("OOS Date: "+data.getOOSDate());
                        break;
                    case 5:
                        data.setStatus(colVals.get(j).getText().replace("\n","").replace("\r",""));
                        System.out.println("Status: "+data.getStatus());
                    default:  
                        break;
                     
                }
                //End Second For Loop
            }
       
        String SQL = String.format("insert into OOS values('%s','%s','%s','%s','%s','%s');",data.getUSDOT().replaceAll(" ",""),data.getLegalName(),data.getAddress(),data.getOOSReason(),data.getOOSDate(),data.getStatus());
           try { 
               File myFile = new File("C:\\Users\\jardo\\ColoradoSQL\\ColoradoSQL.txt");
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(myFile, true)); 
            PrintWriter pr = new PrintWriter(out);
            pr.println(SQL);
            pr.close();
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
        //End First For Loop    
    }
    
}
}