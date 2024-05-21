package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.com.generic.fileutility.ExcelUtility;

public class OrganizationsSearchPage {
public OrganizationsSearchPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@id='search_txt']")
private WebElement searchtxt;
public WebElement getSearchtxt() {
	return searchtxt;
}

public WebElement getSearch() {
	return search;
}

public WebElement getOrgselectdd() {
	return orgselectdd;
}
@FindBy(name="search")
private WebElement search;

@FindBy(name="search_field")
private WebElement orgselectdd;

public void searchorg(String organizationname) {
	Select select= new Select(orgselectdd);
	select.selectByVisibleText(organizationname);
}


}
