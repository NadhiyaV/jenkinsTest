package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.com.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
@Test(dataProvider = "getData")
public void getProductInfoTest(String brandName, String productName) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//search products
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
	//capture product info
	//String x="//div[@class='a-section']//span[@class='a-price']";
	String x="//span[contains(text(),'"+productName+"')]/../../../../../../../div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/div[1]/a/span/span[1]";
	//String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/a/span/sapn[2]/span[2]";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
}	
	@DataProvider
	public Object[][] getData() throws Throwable, IOException {
		ExcelUtility elib= new ExcelUtility();
		int rowcount=elib.getRowCount("PRODUCT");
		Object[][] objarray= new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) {
			objarray[i][0]=elib.getDatafromExcel("PRODUCT", i+1, 0);
			objarray[i][1]=elib.getDatafromExcel("PRODUCT", i+1, 1);
		}
		return objarray;
		/*
		 * objarray[0][0]="iphone"; objarray[0][1]="Apple iphone 12 (128GB) - Black";
		 * 
		 * 
		 * objarray[1][0]="iphone"; objarray[1][1]="Apple iphone 12 (128GB) - Midnight";
		 * 
		 * 
		 * objarray[2][0]="iphone";
		 * objarray[2][1]="Apple iphone 12 (128GB) - StarLight";
		 */

		
		
	}
}