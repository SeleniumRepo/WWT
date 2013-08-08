package com.wwt.test.puma.pumaSearchTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pageObjects.PageObjects;

import com.wwt.main.puma.pumaPageObjects.LoginPage;

public class AdvancedSearchTests extends PageObjects {
  @Test
  public void SearchTest() {
	  LoginPage lp = new LoginPage();
      lp.login();
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	    driver.get("https://www-dev.wwt.com/puma");
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
