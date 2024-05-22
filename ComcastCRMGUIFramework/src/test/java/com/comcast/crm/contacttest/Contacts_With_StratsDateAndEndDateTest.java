package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.com.geneic.webdriverutility.JavaUtility;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class Contacts_With_StratsDateAndEndDateTest extends BaseClass {
	@Test(groups="regressionTest")
public void createContactWithStartDate() throws IOException {
				
		String CONTACTNAME =elib.getDatafromExcel("CONTACT", 1, 2) + jlib.getRandomNumber();
		HomePage hp= new HomePage(driver);
		hp.getContactsLink().click();
		CreateNewContactsPage cncp= new CreateNewContactsPage(driver);
		cncp.getLookupimage().click();
		cncp.getContactname().sendKeys(CONTACTNAME);
		String startdate=jlib.getSystemDateYYYYDDMM();
		String enddate=jlib.getRequiredDateYYYYDDMM(30);
		cncp.getStartdate().clear();
		cncp.getStartdate().sendKeys(startdate);
		cncp.getEnddate().clear();
		cncp.getEnddate().sendKeys(enddate);
		cncp.getSavebutton().click();
		
		
		
		/*
		 * driver.findElement(By.linkText("Contacts")).click();
		 * driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 * driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
		 */
		
		//To Create start date and EndDate
		
				
		/*
		 * driver.findElement(By.xpath("//input[@id='jscal_field_support_start_date']"))
		 * .clear();
		 * driver.findElement(By.xpath("//input[@id='jscal_field_support_start_date']"))
		 * .sendKeys(startdate);
		 * driver.findElement(By.xpath("//input[@id='jscal_field_support_end_date']")).
		 * clear();
		 * driver.findElement(By.xpath("//input[@id='jscal_field_support_end_date']")).
		 * sendKeys(enddate);
		 * driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 */
		
		String actalstdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actalstdate.equals(startdate)) {
			System.out.println(actalstdate + "verified =====PASS");
		}
		else {
			System.out.println(actalstdate + "verified =====fail");
		}
	String endda = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
	if(endda.equals(enddate)) {
		System.out.println(endda+"verification===========pass");
	}
	else {
		System.out.println(endda+"verification==============fail");
	}
	
			
		
	}

}
