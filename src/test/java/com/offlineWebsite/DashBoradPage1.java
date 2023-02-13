package com.offlineWebsite;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DashBoradPage1  {
	WebDriver driver=null;
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }

//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
  @BeforeClass()
  public void setup() {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("file:///G:/Driver/javabykiran-Selenium-Softwares%20(1)/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		 driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("123456");
		 driver.findElement(By.xpath("//button")).click();
	  
  }
  @Test(priority=1)
	public void heading()
	{ 	
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Dashboard Courses Offered");
	}
  @Test(priority=2)
  public void dashboard()
  {
	Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
  }
  @Test(priority=3)
	public void linkDisplayed()
  {
	  boolean flag=false;
	  List<WebElement> displayed=driver.findElements(By.xpath("//h3"));
		ArrayList<String> values=new ArrayList<String>();
		values.add("Selenium");
		values.add("Java / J2EE");
		values.add("Python");
		values.add("Php");
		ArrayList<String> disp=new ArrayList<String>();
		for (WebElement  dis : displayed)
		{
			if(dis.isDisplayed())
			{
				flag=true;
				disp.add(dis.getText());
				
			}
				
		}
		Assert.assertEquals(disp, values);
		System.out.println("complete");
  }
  @Test(priority=4)
	public void checkWindowDisplayed(){
  List <WebElement>
	 element=driver.findElements(By.partialLinkText("Mor"));
	 System.out.println(element.size());
	 for (WebElement linkelement : element) {
	 linkelement.click();
	
	 }
	 Set<String> ele =driver.getWindowHandles();
	 driver.close();
	 System.out.println(ele.size());
  }
  @Test(priority=4)
	public void check()
  {
		driver.findElement(By.linkText("JavaByKiran")).click();
  }
//  public void clearFields()
//	{
//		 driver.findElement(By.id("email")).clear();
//			driver.findElement(By.id("password")).clear();
//	}
  @AfterClass
  public void closeWindow()
	{
		 driver.quit();
	}
}
