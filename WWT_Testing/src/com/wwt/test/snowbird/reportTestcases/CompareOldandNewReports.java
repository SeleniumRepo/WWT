package com.wwt.test.snowbird.reportTestcases;

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
  //@Test(dataProvider = "Data-Provider-Function")
  @Test
  public void compareReports() throws InterruptedException {
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

}
