package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class InvoiceTest extends BaseClass{
@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImple.class)
public void activatesim() {
	System.out.println("invoice test  case");
	
	Assert.assertEquals("", "Login Page");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}

}

