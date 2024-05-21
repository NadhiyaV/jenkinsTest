package practiceComCast;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsSearchPage;

public class createContactsTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createContactTest() throws IOException {
		//create Object
		String CONTACTNAME = elib.getDatafromExcel("CONTACT", 1, 2)+jlib.getRandomNumber();
		//String CONTACTNAME = elib.getDatafromExcel("CONTACT", 1, 2) + jlib.getRandomNumber();
		HomePage hp= new HomePage(driver);
		hp.getContactsLink().click();
		CreateNewContactsPage cncp= new CreateNewContactsPage(driver);
		cncp.getContactname().sendKeys(CONTACTNAME);
		cncp.getSavebutton().click();
		
		
		String confmsg=cncp.getContheadermsg().getText();
		
		boolean status=confmsg.contains(CONTACTNAME);
		Assert.assertEquals(status, true);
		//String confmsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(confmsg.contains(CONTACTNAME)) {
//			System.out.println(CONTACTNAME+" verified===========PASS");
//		}
//		else {
//			System.out.println(CONTACTNAME+"verified=============fail");
//		}
		
	}

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
