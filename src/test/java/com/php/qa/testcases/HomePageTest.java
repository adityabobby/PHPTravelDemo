package com.php.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;
import com.php.qa.pages.CMSManagementPage;
import com.php.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CMSManagementPage cmsManagementPageLink;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
		testUtil.explicitWait("Dashboard");
	}
	
	@Test
	public void validateHomePageTitle() throws InterruptedException
	{
		
		String homePageTitle = homePage.homePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Dashboard");
	}
	
	@Test
	public void validateDashboardLabel()
	{
		Assert.assertTrue(homePage.dashboardLabelHeader());
	}
	
	@Test
	public void navigatePagesPage()
	{
		cmsManagementPageLink = homePage.clickPagesLink();
	}
	
	@Test
	public void testLogin()
	{
		System.out.println("this is the sample test case");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
