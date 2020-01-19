package com.php.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.qa.base.TestBase;

public class CMSManagementPage extends TestBase{
	
	@FindBy(xpath="//div[text()='CMS Management']")
	WebElement cmsManagementLabel;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement addBtn;
	
	@FindBy(name="pagetitle")
	WebElement enterPageTitle;
	
	@FindBy(name="pageslug")
	WebElement enterPermaLiink;
	
	@FindBy(name="keywords")
	WebElement enterKeyWords;
	
	@FindBy(name="pagedesc")
	WebElement enterDescription;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	public CMSManagementPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean validateCMSManagementLabel()
	{
		return cmsManagementLabel.isDisplayed();
	}
	
	public void selectPage(String title)
	{
		driver.findElement(By.xpath("//td[@class='xcrud-current xcrud-num']/following-sibling::td[text()='"+title+"']")).click();
	}
	
	public void createPage(String pageTitle, String permaLink, String keywords, String description)
	{
		addBtn.click();
		enterPageTitle.sendKeys(pageTitle);
		enterPermaLiink.sendKeys(permaLink);
		enterKeyWords.sendKeys(keywords);
		enterDescription.sendKeys(description);
		submitBtn.click();
	}

}
