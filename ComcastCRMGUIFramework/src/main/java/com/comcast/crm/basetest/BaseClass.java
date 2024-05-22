package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.com.geneic.webdriverutility.JavaUtility;
import com.comcast.com.geneic.webdriverutility.UtilityClassObject;
import com.comcast.com.geneic.webdriverutility.WebDriverUtility;
import com.comcast.com.generic.fileutility.ExcelUtility;
import com.comcast.com.generic.fileutility.FileUtility;
import com.comcast.com.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public static WebDriver driver=null;
	public static WebDriver sdriver;
	public DataBaseUtility dblib = new DataBaseUtility();
	public static FileUtility flib = new FileUtility();
	public static ExcelUtility elib= new ExcelUtility();
	public JsonUtility jslib= new JsonUtility();
	public static JavaUtility jlib= new JavaUtility();
	public static WebDriverUtility wlib= new WebDriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	
	@BeforeSuite(groups = {"smokeTest" , "regressionTest" })
	public void getConnectionWithDB() {
		System.out.println("========connection to DB=========");
		dblib.getConnection();
		
	}
	@AfterSuite(groups = {"smokeTest" , "regressionTest" })
	public void closeConnectionWithDB() throws SQLException {
		System.out.println("=============close the connection with DB");
		dblib.closeConnection();
		
	}
	//@Parameters(BROWSER)
	@BeforeClass(groups = {"smokeTest" , "regressionTest" })
	public void toLaunchBrowser(/*String browser*/) throws IOException {
		System.out.println("===============To Launch Browser===========");
		//String BROWSER = browser;
		String BROWSER=flib.getDatafromProperties("browser");
		System.out.println(BROWSER);
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("edge")){
			driver = new EdgeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		
	}
	@AfterClass(groups = {"smokeTest" , "regressionTest" })
	public void toQuittheBrowser() throws SQLException {
		System.out.println("=============To Quit the Browser===========");
		driver.quit();
	}
	@BeforeMethod(groups = {"smokeTest" , "regressionTest" })
	public void tologintoapp() throws IOException {
		System.out.println("============To Login to Application");
		System.out.println(driver);
		LoginPage lp= new LoginPage(driver);
		String URL = flib.getDatafromProperties("url");
		String USERNAME = flib.getDatafromProperties("username");
		String PASSWORD = flib.getDatafromProperties("password");
		lp.loginToApp(URL, USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups = {"smokeTest" , "regressionTest" })
	public void logoutofapp() {
		System.out.println("===========logout Application=========");
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
	}
	
}
