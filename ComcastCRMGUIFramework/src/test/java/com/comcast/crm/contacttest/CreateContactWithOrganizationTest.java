package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.com.geneic.webdriverutility.JavaUtility;
import com.comcast.com.geneic.webdriverutility.WebDriverUtility;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsSearchPage;

public class CreateContactWithOrganizationTest extends BaseClass {
	@Test(groups="regressionTest")
	public void createContactsWithOrganizationTest() throws IOException, InterruptedException {
		// create Organization
		String ORGNAME = elib.getDatafromExcel("ORG", 7, 2) + jlib.getRandomNumber();
		String CONTACTNAME = elib.getDatafromExcel("CONTACT", 7, 3) + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrglookImage().click();
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createorg(ORGNAME);

		// create Contact
		Thread.sleep(2000);
		hp.getContactsLink().click();
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getLookupimage().click();
		Thread.sleep(2000);
		cncp.getContactname().sendKeys(CONTACTNAME);

		Thread.sleep(2000);
		String parentid = driver.getWindowHandle();
		cncp.getNeworgaddbtn().click();
		OrganizationsSearchPage osp = new OrganizationsSearchPage(driver);

		// driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		wlib.switchToNewBrowserTab(driver, "module=Accounts");
		Thread.sleep(2000);
		osp.getSearchtxt().sendKeys(ORGNAME);
		// osp.searchorg(ORGNAME);
		osp.getSearch().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
		driver.switchTo().window(parentid);
		cncp.getSavebutton().click();

		String headermsg = cncp.getContheadermsg().getText();

		if (headermsg.contains(CONTACTNAME)) {
			System.out.println(CONTACTNAME + "Verified============PASSED");
		} else {
			System.out.println(CONTACTNAME + "Verified============FAILED");
		}
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualorgname = cip.getActualorgname().getText();

		System.out.println(actualorgname);
		if (actualorgname.trim().equals(ORGNAME)) {
			System.out.println(actualorgname + " =========passed");
		} else {
			System.out.println(actualorgname + " ===========FAILED");
		}

	}

}
