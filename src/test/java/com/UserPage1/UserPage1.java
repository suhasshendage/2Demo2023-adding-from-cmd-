package com.UserPage1;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class UserPage1 {
	WebDriver driver=null;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() throws Exception {
	  FileInputStream fis= new FileInputStream("testdata.xls");
	  	Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet("Sheet2");
		int clm=sh.getColumns();
		System.out.println(clm);
		int rows=sh.getRows();
		System.out.println(rows);
		 String [] [] obj=new String [rows][clm];
		
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<clm;j++)
			{
				Cell cell=sh.getCell(j, i);
				String data=cell.getContents();
				obj[i][j]=data;
				System.out.println(data);
			}
		}  
		return obj;
  }
  @BeforeClass
	public void setup()
	{
		 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("file:///G:/Driver/javabykiran-Selenium-Softwares%20(1)/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/users.html");
		 clearFields();
		 driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("123456");
		 driver.findElement(By.xpath("//button")).click();
		 driver.findElement(By.xpath("//a[@href='users.html']")).click();
	}

  private void clearFields() {
	// TODO Auto-generated method stub
	
}

@AfterClass
  public void afterClass() {
  }

}
