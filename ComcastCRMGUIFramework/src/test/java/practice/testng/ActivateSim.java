package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ActivateSim extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImple.class)
	public void activatesim() {
		System.out.println("invoice test  case");
		String actualTitle=driver.getTitle();
		Assert.assertEquals("actualTitle", "Login Page");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	@Test
	public void activatesimTest() {
		System.out.println("invoice test  case");
		
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
