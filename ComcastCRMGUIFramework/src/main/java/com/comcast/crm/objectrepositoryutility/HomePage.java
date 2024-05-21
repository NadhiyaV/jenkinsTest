package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText = "Products")
	private WebElement productlink;
	
	public WebElement getProductlink() {
		return productlink;
	}
	public void setProductlink(WebElement productlink) {
		this.productlink = productlink;
	}
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	@FindBy(linkText="Campaigns")
	private WebElement campaignslink;
	public WebElement getCampaignslink() {
		return campaignslink;
	}
	@FindBy(linkText="More")
	private WebElement moreLink;
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public void navigateToCampaigns(WebDriver driver) {
		Actions act= new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignslink.click();
				
	}
	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement adminImg;
	
	public WebElement getAdminImg() {
		return adminImg;
		
	}
	@FindBy(xpath="(//a[contains(text(),'Sign')])")
	private WebElement signout;
	
	public WebElement getSignout() {
		return signout;
	}
	public void logout(WebDriver driver) {
		Actions action= new Actions(driver);
		action.moveToElement(adminImg).perform();
		signout.click();
		
	}
}
