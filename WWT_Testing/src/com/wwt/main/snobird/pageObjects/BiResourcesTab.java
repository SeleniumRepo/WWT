package com.wwt.main.snobird.pageObjects;

import java.util.HashMap;
import java.util.Map;

import bsh.This;
import dataLoad.FileData;
import pageObjects.Button;
import pageObjects.InputField;
import pageObjects.Link;
import pageObjects.PageObjects;
import pageObjects.SelectList;
import pageObjects.Table;

public class BiResourcesTab extends PageObjects{
	
	
	
	public Link biResourcesLink; 
	public Button searchReportsButton;
	public Table searchReportsTable;
	public SelectList reportFieldSelectList; // first Field in search Criteria
	public SelectList opsSelectList;
	
	public BiResourcesTab(){
		
		load();
		
	}
	
	private void load(){
		
		String projectPath = null;
		projectPath = new java.io.File("").getAbsolutePath();
		
		Map<String,String> locators = new HashMap<String,String>();
		FileData data = new FileData();
		String file = projectPath+"\\snobirdPageObjectFiles\\BiResourcesTab.xls" ;
		locators=data.getValues(file);
		
		try {
			//@Todo: Validate the xpaths using Selenium ide. Xpaths are in the xls fiel worldWideTechnology
		//	favoritesTabLink = new Link(locators.get(This.class.getField("biResourcesLink").toString()));//@Todo: need to see if it works
			biResourcesLink = new Link(locators.get(This.class.getField("biResourcesLink").toString()));
			searchReportsButton= new Button(locators.get("searchReportsButton"));
			searchReportsTable = new Table(locators.get("dearchReportsTable"));
			reportFieldSelectList = new SelectList(locators.get("reportFieldSelectList"));
            opsSelectList = new SelectList(locators.get("opsSelectList"));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void clickSearch(){
		
		searchReportsButton.click();
	}

}
