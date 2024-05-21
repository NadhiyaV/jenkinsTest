package practiceComCast;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.com.geneic.webdriverutility.UtilityClassObject;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.listenerUtility.ListenerImplementation;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplementation.class)
public class createOrganizationsTest extends BaseClass{
	
	@Test(groups="smokeTest")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		//step 1 login to an application		
		//step 2:navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		ListenerImplementation.test.log(Status.INFO,"read data from excel");
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
