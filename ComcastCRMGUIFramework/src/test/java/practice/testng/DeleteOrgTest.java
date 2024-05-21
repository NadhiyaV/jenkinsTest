package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class DeleteOrgTest extends BaseClass{
@Test
	public void deleteTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//step 2:navigate to organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		hp.getCampaignslink();
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getOrglookImage().click();
		String ORGNAME = elib.getDatafromExcel("ORG", 1, 2)+jlib.getRandomNumber();
		CreateNewOrganizationPage cop= new CreateNewOrganizationPage(driver);
		cop.createorg(ORGNAME);
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String actualargname=oip.getHeadermsg().getText();
		if(actualargname.contains(ORGNAME)) {
			System.out.println(ORGNAME+" name is verified ==pass");
		}else {
			System.out.println(ORGNAME+" name is not verified ==fail");
		}
		Thread.sleep(2000);
		hp.getOrgLink().click();
		OrganizationsPage osp= new OrganizationsPage(driver);
		osp.getSearchtxt().sendKeys(ORGNAME);
		wlib.select(osp.getIndd(),"Organization Name");
		osp.getSubmitbtn().click();
		//dynamic webelement 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+ ORGNAME +"']/../../td[8]/a[text()='del']")).click();
		wlib.switchToAlertAccept(driver);
		
	}

}
