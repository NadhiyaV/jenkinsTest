package practice.homeTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageSampleTest {

	@Test
	public void homePageTest() {
		Reporter.log("start test");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertTrue(false);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log("end test");
		
	}
	@Test
	public void loginpagehomePageTest() {
		Reporter.log("start test");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log("end test");
		
	}
}
