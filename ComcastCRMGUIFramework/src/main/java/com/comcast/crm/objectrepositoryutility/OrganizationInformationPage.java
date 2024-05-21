package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(className="dvHeaderText")
private WebElement headermsg;

public WebElement getHeadermsg() {
	return headermsg;
}
@FindBy(xpath="//span[@id='dtlview_Industry']")
private WebElement indestrydd;
public WebElement getIndestrydd() {
	return indestrydd;
}
@FindBy(xpath="//span[@id='dtlview_Type']")
private WebElement typedd;

public WebElement getTypedd() {
	return typedd;
}


}
