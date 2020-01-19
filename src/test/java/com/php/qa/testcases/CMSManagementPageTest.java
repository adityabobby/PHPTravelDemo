package com.php.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.CMSManagementPage;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;
import com.php.qa.util.TestUtil;

public class CMSManagementPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CMSManagementPage cmsManagementPageLink;
	TestUtil testUtil;
	String sheet="CMSManagement";

	public CMSManagementPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
		testUtil.explicitWait("Dashboard");
		cmsManagementPageLink = homePage.clickPagesLink();
		testUtil.explicitWait("CMS Management");
	}

	@Test
	public void validateCMSManagementLabelTest() {
		Assert.assertTrue(cmsManagementPageLink.validateCMSManagementLabel());
	}
	
	@Test
	public void selectSinglePageTitle()
	{
		cmsManagementPageLink.selectPage("Cars");
	}
	
	@Test
	public void selectMultiplePageTitle()
	{
		cmsManagementPageLink.selectPage("Cars");
		cmsManagementPageLink.selectPage("TravelhopeHotels");
	}
	
	@DataProvider
	public Object[][] pHPData()
	{
		Object[][] data = testUtil.getPHPTestData(sheet);
		return data;
	}
	
	@Test(dataProvider="pHPData")
	public void validateCreatePage(String pageTitle,String permaLink,String keywords,String description)
	{
		cmsManagementPageLink.createPage(pageTitle, permaLink, keywords, description);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
