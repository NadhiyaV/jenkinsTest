package practice.testng;

import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
public class SameTestScreenShot {
	@Test
	public void amazontest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");
		//step1: create object for evenfiringwebdriver
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		
		//use the getscreenshot method
		
		File src=edriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./ScreenShot/amezon.png"));
		
	}

}
