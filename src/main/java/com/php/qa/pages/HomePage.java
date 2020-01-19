package com.php.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//p[text()='DASHBOARD']")
	WebElement dashboardLabel;
	
	@FindBy(xpath="//span[text()='CMS']")
	WebElement cmsLink;
	
	@FindBy(xpath="//a[text()='Pages']")
	WebElement pagesLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public Boolean dashboardLabelHeader()
	{
		return dashboardLabel.isDisplayed();
	}
	
	public CMSManagementPage clickPagesLink()
	{
		cmsLink.click();
		pagesLink.click();
		return new CMSManagementPage();
	}
}
