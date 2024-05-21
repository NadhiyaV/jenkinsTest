package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	//private static final String industry = null;
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(name="accountname")
private WebElement orgNameEdt;
@FindBy(xpath="//input[@id='phone']")
private WebElement phoneno;
public WebElement getPhoneno() {
	return phoneno;
}
@FindBy(id="dtlview_Phone")
private WebElement acualphoneno;

public WebElement getAcualphoneno() {
	return acualphoneno;
}

public WebElement getOrgNameEdt() {
	return orgNameEdt;
}

@FindBy(name="button")
private WebElement savebtn;
public WebElement getSavebtn() {
	return savebtn;
}
@FindBy(name="industry")
private WebElement industrydd;
public WebElement getIndustrydd() {
	return industrydd;
}
@FindBy(name="accounttype")
private WebElement typedd;
public WebElement getTypedd() {
	return typedd;
}
public void setTypedd(WebElement typedd) {
	this.typedd = typedd;
}
public void createorg(String orgname) {
	orgNameEdt.sendKeys(orgname);
	savebtn.click();
}
public void createorg(String ORGNAME, String industry) {
	orgNameEdt.sendKeys(ORGNAME);
	Select select= new Select(industrydd);
	select.selectByVisibleText(industry);
	savebtn.click();
}

public void createorgwithtwodd(String ORGNAME, String industry,String  type) {
	orgNameEdt.sendKeys(ORGNAME);
	Select select1= new Select(industrydd);
	select1.selectByVisibleText(industry);
	Select select2= new Select(typedd);
	select2.selectByVisibleText(type);
	savebtn.click();
}
public void createOrgWithPhoneno(String ORGNAME,String phonenumber) {
	orgNameEdt.sendKeys(ORGNAME);
	phoneno.sendKeys(phonenumber);
	savebtn.click();
}

}
