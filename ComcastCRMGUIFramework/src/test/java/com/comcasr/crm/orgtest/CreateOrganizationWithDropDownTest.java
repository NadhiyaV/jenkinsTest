package com.comcasr.crm.orgtest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.com.geneic.webdriverutility.JavaUtility;
import com.comcast.com.geneic.webdriverutility.WebDriverUtility;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithDropDownTest extends BaseClass{
@Test(groups="regressionTest")
	public void createOrganizationWithDropDownTest() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrglookImage().click();
		
		// Read data from Excel file
		String ORGNAME = elib.getDatafromExcel("ORG", 1, 2) + jlib.getRandomNumber();
		String INDUSTDD = elib.getDatafromExcel("ORG", 4, 3);
		String TYPE = elib.getDatafromExcel("ORG", 4, 4);
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createorgwithtwodd(ORGNAME, INDUSTDD, TYPE);
		
		// TO VERIFY TYPE DROPDOWN
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualdataindudd = oip.getIndestrydd().getText();
		if (actualdataindudd.equals(INDUSTDD)) {
			System.out.println(actualdataindudd + "verified===========PASSES");
		} else {
			System.out.println(actualdataindudd + "verified=============FAILED");
		}

		String actualltypedd = oip.getTypedd().getText();
		if (actualltypedd.equals(TYPE)) {
			System.out.println(actualltypedd + "verified=========PASSED");
		} else {
			System.out.println(actualltypedd + "verified=========FAILED ");
		}
		
	}

}
