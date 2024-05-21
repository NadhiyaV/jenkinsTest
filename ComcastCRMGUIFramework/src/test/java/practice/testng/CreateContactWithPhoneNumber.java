package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithPhoneNumber {
	@Test(dataProvider = "getData")
	public void createContactWithPhoneNoTest(String firstname, String lastname, long phoneno) {
		System.out.println("FirstName:" + firstname+ "LastName"+lastname+"phoneNo"+phoneno);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objarray= new Object[3][3];
		objarray[0][0]="deepak";
		objarray[0][1]="HR";
		objarray[0][2]=999999999l;

		objarray[1][0]="deepak";
		objarray[1][1]="HR";
		objarray[1][2]=888888888l;

		objarray[2][0]="deepak";
		objarray[2][1]="HR";
		objarray[2][2]=7777777777l;

		return objarray;
		
	}

}
