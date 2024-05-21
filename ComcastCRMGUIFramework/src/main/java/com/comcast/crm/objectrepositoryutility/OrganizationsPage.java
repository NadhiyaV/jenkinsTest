package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
public OrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement orglookImage;

public WebElement getOrglookImage() {
	return orglookImage;
}
@FindBy(name="search_text")
private WebElement searchtxt;
public WebElement getSearchtxt() {
	return searchtxt;
}
public WebElement getIndd() {
	return Indd;
}
public WebElement getSubmitbtn() {
	return submitbtn;
}
@FindBy(id="bas_searchfield")
private WebElement Indd;
@FindBy(name="submit")
private WebElement submitbtn;

}
