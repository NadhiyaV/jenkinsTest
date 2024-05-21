package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReport {
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvaceReports/report.html");
		spark.config().setDocumentTitle("Advanced Reports");
		spark.config().setReportName("Extent Reports");
		spark.config().setTheme(Theme.DARK);
		//steps to add environment info and create info
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "chrome");
	}
	@AfterClass
	public void configAs() {
		report.flush();
	}

	@Test
	public void createExtentReports() {
		
		//steps to spark report config
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		TakesScreenshot ts= (TakesScreenshot) driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		
		
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "LOGIN TO APPLICATION");
		test.log(Status.INFO,"Navigate to Application");
		test.log(Status.INFO,"create contact information");
		if("homee".equals("home")) {
		test.log(Status.PASS, "contact is verified");
		}else {
			test.addScreenCaptureFromBase64String(filepath, "Error File");
			
		}
		
		
	}
	@Test
	public void createContactWithPhoneNo() {
		
		//steps to spark report config
		
		ExtentTest test = report.createTest("createContactWithPhoneNo");
		test.log(Status.INFO, "LOGIN TO APPLICATION");
		test.log(Status.INFO,"Navigate to Application");
		test.log(Status.INFO,"create contact with phoneno information");
		if("home".equals("home")) {
		test.log(Status.PASS, "contact is verified");
		}else {
			test.log(Status.FAIL, "contact is not verified");
		}
		
		
	}
	
	@Test
	public void createContactWithOrganization() {
		
		//steps to spark report config
		
		ExtentTest test = report.createTest("createContactWithOrganization");
		test.log(Status.INFO, "LOGIN TO APPLICATION");
		test.log(Status.INFO,"Navigate to Application");
		test.log(Status.INFO,"create contact with Organization information");
		if("home".equals("home")) {
		test.log(Status.PASS, "contact is verified");
		}else {
			test.log(Status.FAIL, "contact is not verified");
		}
		
		
	}
}

