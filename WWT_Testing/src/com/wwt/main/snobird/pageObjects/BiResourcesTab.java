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
	public InputField dataInputField;
	
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
		//	biResourcesLink = new Link(locators.get(This.class.getField("biResourcesLink").toString()));
			searchReportsButton= new Button(locators.get("searchReportsButton"));
			//searchReportsTable = new Table(locators.get("searchReportsTable"));
			//reportFieldSelectList = new SelectList(locators.get("reportFieldSelectList"));
            //opsSelectList = new SelectList(locators.get("opsSelectList"));
		    //	dataInputField = new InputField(locators.get("dataInputField"));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e){
			System.out.println("Element load failed");
			e.printStackTrace();
		}
	
	}
	
	public void clickSearch(){
		try{
		searchReportsButton.click();
		}catch(Exception e){
			System.out.println("searchReportButton click failed");
			e.printStackTrace();
		}
	}
	
	public void inputSearchData(String searchData){
	
		try{
			waitForElement(dataInputField.element,1000);
			dataInputField.inputText(searchData);
			}catch(Exception e){
				System.out.println("searchReportButton click failed");
				e.printStackTrace();
			}
	}
	//@Todo: Create another Over loading method to select ReportName, Ops and then enter searchData

}
