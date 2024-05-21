package com.comcast.crm.contacttest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass{
@Test(groups="smokeTest")
	public void createContactTest() throws IOException {
		//create Object
		String CONTACTNAME = elib.getDatafromExcel("CONTACT", 1, 2)+jlib.getRandomNumber();
		//String CONTACTNAME = elib.getDatafromExcel("CONTACT", 1, 2) + jlib.getRandomNumber();
		HomePage hp= new HomePage(driver);
		hp.getContactsLink().click();
		CreateNewContactsPage cncp= new CreateNewContactsPage(driver);
		cncp.getLookupimage().click();
		cncp.getContactname().sendKeys(CONTACTNAME);
		cncp.getSavebutton().click();
		
		
		String confmsg=cncp.getContheadermsg().getText();
		//String confmsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(confmsg.contains(CONTACTNAME)) {
			System.out.println(CONTACTNAME+" verified===========PASS");
		}
		else {
			System.out.println(CONTACTNAME+"verified=============fail");
		}
		
	}

}
