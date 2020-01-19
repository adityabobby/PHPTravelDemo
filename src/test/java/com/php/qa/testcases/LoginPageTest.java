package com.php.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		loginPage=new LoginPage();
	}
	
	@Test()
	public void valdiateLoginpageTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Administator Login");
	}
	
	@Test()
	public void validateLoginPanelHeader()
	{
		Assert.assertTrue(loginPage.loginPagePanelHeader());
	}
	
	@Test
	public void validateLogin()
	{
		 homePage = loginPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
