package com.wwt.main.snobird.pageObjects;

import java.util.HashMap;
import java.util.Map;

import dataLoad.FileData;
import pageObjects.Button;
import pageObjects.InputField;
import pageObjects.Link;
import pageObjects.PageObjects;
import utility.Util;

public class MainPage extends PageObjects{
	
	public Link biResourcesLink; 
	public Link favoriteLink;
	
	public MainPage(){
		
		load();
	}
	
	private void load(){
		String projectPath = null;
		projectPath = new java.io.File("").getAbsolutePath();
		
		Map<String,String> locators = new HashMap<String,String>();
		FileData data = new FileData();
		String file = projectPath+"\\snobirdPageObjectFiles\\MainPage.xls" ;
		locators=data.getValues(file);
		System.out.println("biresources element locator path is "+ locators.get("biResourcesLink"));
		biResourcesLink = new Link(locators.get("biResourcesLink"));
		
		favoriteLink = new Link(locators.get("favoriteLink"));
		
	   
		
	}
	
	public void navToBiresourceTab(){
		
		waitForElement(biResourcesLink.element,Util.waitTime);
		biResourcesLink.click();
		//@Todo: have to write Logic to wait
		
	}
	

}
