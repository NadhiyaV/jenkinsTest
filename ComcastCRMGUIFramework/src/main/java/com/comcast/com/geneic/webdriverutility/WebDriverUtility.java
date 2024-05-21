package com.comcast.com.geneic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToNewBrowserTab(WebDriver driver,String particalURL) {
		Set<String> allwindows = driver.getWindowHandles();
		for(String ids:allwindows) {
		driver.switchTo().window(ids);
		String Curl=driver.getCurrentUrl();
		if(Curl.contains(particalURL)) {
			break;
		}
		}
		
	}
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> allwindows = driver.getWindowHandles();
		for(String ids:allwindows) {
		driver.switchTo().window(ids);
		String Curl=driver.getTitle();
		if(Curl.contains(partialTitle)) {
			break;
		}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	public void mousemoveOnElement(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();;
	}
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
}
