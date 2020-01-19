package com.php.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.php.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=30;
	public static long EXPLICIT_WAIT=10;
	public static FileInputStream fis=null;
	public static Workbook book;
	public static Sheet sh;
	
	public void explicitWait(String pageTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
		wait.until(ExpectedConditions.titleIs(pageTitle));
	}
	
	public Object[][] getPHPTestData(String sheetName)
	{
		try
		{
			 fis = new FileInputStream("C://Users/aditya/workspace/PHPTravelsTest/src/main/java/com/php/qa/testdata/testdata.xlsx");
		}
		catch(FileNotFoundException e){
			System.out.println("the file is not present");
		}
		try{
		 book = WorkbookFactory.create(fis);
		}
		catch(Exception e)
		{
			System.out.println("it is the exception");
		}
		 sh = book.getSheet(sheetName);
		 Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		 for(int i=0;i<sh.getLastRowNum();i++)
		 {
			 for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
			 {
				 data[i][k]=sh.getRow(i+1).getCell(k).toString();
			 }
		 }
		 return data;
		
	}

}
