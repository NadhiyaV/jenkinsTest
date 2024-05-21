package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDataProviderTest {
@Test(dataProvider = "getdata")
public void createContactTest(String firstname,String lastname) {
	System.out.println("Firast Name:" +firstname + "Last Name: " +lastname );
}

@DataProvider
public Object[][] getdata(){
	Object[][] objary=new Object[3][2];
	objary[0][0]="deepak";
	objary[0][1]="HR";
	objary[1][0]="sam";
	objary[1][1]="HD";
	objary[2][0]="john";
	objary[2][1]="smith";
	
	return objary;
	
}
}
