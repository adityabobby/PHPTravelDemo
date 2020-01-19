package com.php.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="email")
	WebElement emailObj;
	
	@FindBy(name="password")
	WebElement pwdObj;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//strong[text()='Login Panel']")
	WebElement loginPanelHeader;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public Boolean loginPagePanelHeader()
	{
		return loginPanelHeader.isDisplayed();
	}
	
	public HomePage login(String emailId, String password)
	{
		emailObj.sendKeys(emailId);
		pwdObj.sendKeys(password);
		loginBtn.click();
		
		return new HomePage();
	}
}
