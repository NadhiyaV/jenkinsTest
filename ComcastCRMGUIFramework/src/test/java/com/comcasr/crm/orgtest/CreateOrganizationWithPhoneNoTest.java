package com.comcasr.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.com.geneic.webdriverutility.JavaUtility;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPhoneNoTest extends BaseClass{

	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNoTest() throws IOException {

		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getOrglookImage().click();

		//Read data from Excel file
		String ORGNAME = elib.getDatafromExcel("ORG", 1, 2)+jlib.getRandomNumber();
		String PHONENO = elib.getDatafromExcel("ORG", 7, 3);
		CreateNewOrganizationPage cop= new CreateNewOrganizationPage(driver);
		/*
		 * cop.createorg(ORGNAME); cop.getPhoneno().sendKeys(PHONENO);
		 * cop.getSavebtn().click();
		 */
		cop.createOrgWithPhoneno(ORGNAME, PHONENO);
		String actualphoneno=cop.getAcualphoneno().getText();
		if(actualphoneno.equals(PHONENO)) {
			System.out.println(actualphoneno + "is verified=========PASS");
		}
		else {
			System.out.println(actualphoneno + "is verified=========FAIL");
		}
	}

}
