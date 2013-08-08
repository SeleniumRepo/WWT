package com.wwt.test.snowbird.reportTestcases;

import java.io.IOException;
import java.util.Vector;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.wwt.main.snobird.pageObjects.BiResourcesTab;
import com.wwt.main.snobird.pageObjects.LoginPage;
import com.wwt.main.snobird.pageObjects.MainPage;

import pageObjects.PageObjects;

public class CompareOldandNewReports extends PageObjects{
  @Test
  public void compareReports(String oldReport,String newReport,String busUnit, String templateName) throws InterruptedException {
	  LoginPage lp = new LoginPage();
		lp.login();
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
				
		alert.accept();
		//driver.findElement(By.xpath("//*[@id='tabs']/ul/li[2]/a")).click();;
	    MainPage main = new MainPage();
	    main.navToBiresourceTab();
	    BiResourcesTab br = new BiResourcesTab();
	    br.clickSearch();
	    Thread.sleep(1000);
	   // br.inputSearchData("Sing gah");
	    String x = "Sing gah";
	    driver.findElement(By.cssSelector("td[class=data]>input")).sendKeys("Shipping GAH");
	    
	   //From here it should loop through the testData. Just printing the test data for testing purpose
	    System.out.println(oldReport+" "+ newReport+" "+busUnit+" "+ templateName);
  }
  

  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver.get("https://www-dev.wwt.com/snobird");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("webbrowser opened");
		System.out.println("WWT.com ne");
		Thread.sleep(5000);
		driver.get("https://secure-dev.wwt.com/nidp/idff/sso?id=4&sid=1&option=credential&sid=1");
		
  }

  @AfterTest
  public void afterTest() {
  }
  
//This function will provide the parameter data
	@DataProvider(name = "reportData")
	public String[][] testData() {
		String[][] SnoBirdInputFile = null;
		String projectPath  = new java.io.File("").getAbsolutePath();
		String SnoBirdInputPath = projectPath+"\\snobirdTestData\\SnoBirdInputFile.xls" ;
		try {
			SnoBirdInputFile= dataLoad.ExcelFile.ReadMyExcel(SnoBirdInputPath, "SnoBirdInputFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
	  return SnoBirdInputFile;
		
	}
	
	

}
