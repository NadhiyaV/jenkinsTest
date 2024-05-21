package com.comcasr.crm.orgtest;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException {
		//step 1 login to an application		
		//step 2:navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getOrglookImage().click();
		CreateNewOrganizationPage cop= new CreateNewOrganizationPage(driver);
		String ORGNAME = elib.getDatafromExcel("ORG", 1, 2)+jlib.getRandomNumber();
		cop.createorg(ORGNAME);
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String actualargname=oip.getHeadermsg().getText();
		if(actualargname.contains(ORGNAME)) {
			System.out.println(ORGNAME+" name is verified ==pass");
		}else {
			System.out.println(ORGNAME+" name is not verified ==fail");
		}
				
	}
	
}
