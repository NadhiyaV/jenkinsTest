package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	final int a=5;
	@Test(priority = a)
	public void createContactTest() {
		System.out.println("create contact test case");
	}
	@Test(alwaysRun = true)
	public void modifyContactTest() {
		System.out.println("modify contact test case");
	}
	@Test(enabled = false)
	public void deleteContactTest() {
		System.out.println("delete contact test case");
	}
	

}
