package com.php.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.php.qa.util.TestUtil;



public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream(
					"/Users/aditya/workspace/PHPTravelsTest/src/main/java/com/php/qa/config/config.properties");
			prop.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialisation() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
