package com.wwt.main.puma.pumaPageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dataLoad.FileData;
import pageObjects.Button;
import pageObjects.InputField;
import pageObjects.PageObjects;
import utility.Util;

public class LoginPage extends PageObjects {
	public InputField userName = null;
	public InputField password = null;
	public Button  loginButton = null;
	
  public LoginPage(){
	  
	  load();
  }
	
	public static  void main(String args[]) throws InterruptedException{
		driver.get("https://www-dev.wwt.com/puma");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("webbrowser opened");
		System.out.println("WWT.com ne");
		Thread.sleep(5000);
		driver.get("https://secure-dev.wwt.com/nidp/idff/sso?id=4&sid=1&option=credential&sid=1");
		LoginPage lp = new LoginPage();
		lp.load();
		lp.login();
	
		
	}
	
	private void load(){
		String projectPath = null;
		projectPath = new java.io.File("").getAbsolutePath();
		
		Map<String,String> locators = new HashMap<String,String>();
		FileData data = new FileData();
		String file = projectPath+"\\pageObjectFiles\\LoginData.xls" ;
		locators=data.getValues(file);
		
		userName = new InputField(locators.get("username"));
		
	    password = new InputField(locators.get("password"));
	    
	    loginButton = new Button(locators.get("loginButton"));
	   
		
	}
	
	public void login(){
		
		userName.inputText("maheshwg"); // @Todo: need to change to take it from excel file
		password.inputText("n8cRebRa");//@Todo: need to change to take it from excel file
		//loginButton.clickAndWait(locator, timeout);
		loginButton.click();
		
		 try {
				Thread.sleep(Util.waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("wait Time exceeded");
			}
		    
		  //  waitForElement(super.getElement("id=gbox_myProjectTable"),Util.waitTime);
		    
		    driver.get("https://www-dev.wwt.com/puma");
		   
		
	}
	

}
