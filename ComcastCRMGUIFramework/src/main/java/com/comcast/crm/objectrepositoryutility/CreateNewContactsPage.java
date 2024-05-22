package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement lookupimage;
	@FindBy(xpath="//input[@name='lastname']")
	//@FindBy(name="lastname")
	private WebElement contactname;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement neworgaddbtn;
	public WebElement getNeworgaddbtn() {
		return neworgaddbtn;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contheadermsg;
	@FindBy(xpath="//input[@id='jscal_field_support_start_date']")
	private WebElement startdate;
	@FindBy(xpath="//input[@id='jscal_field_support_end_date']")
	private WebElement enddate;
	public WebElement getLookupimage() {
		return lookupimage;
	}
	public WebElement getContactname() {
		return contactname;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getContheadermsg() {
		return contheadermsg;
	}
	public WebElement getStartdate() {
		return startdate;
	}
	public WebElement getEnddate() {
		return enddate;
	}

}
