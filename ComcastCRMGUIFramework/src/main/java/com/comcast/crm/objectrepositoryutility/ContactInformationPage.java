package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[@class='dvtCellInfo' and @id='mouseArea_Organization Name']")
	private WebElement actualorgname;
	public WebElement getActualorgname() {
		return actualorgname;
	}

}
