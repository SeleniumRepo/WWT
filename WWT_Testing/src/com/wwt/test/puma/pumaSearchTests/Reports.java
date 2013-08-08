package com.wwt.test.puma.pumaSearchTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjects.loginsnobird;

public class Reports extends loginsnobird{
	private By BiResourcesTab = By.xpath(".//*[@id='tabs']/ul/li[2]/a");
	private By SearchButton = By.id("searchReportsButton");
	private By SearchReportsTab = By.xpath("//*[@id='fbox_biResrcTable']/table/tbody/tr[1]/td[3]/input");
	private By findTab = By.xpath("//*[@id='fbox_biResrcTable']/table/tfoot/tr/td[1]/span[2]");
	public String searchName = "Shipping gah";
	private By ShippinggahOldReportClick = By.xpath("//*[@id='109']/td[4]/b/a");
	private By BuisinessUnit = By.cssSelector("#tmplbusunit_drpdwn_hGroup001");
	
	
	@Test
	public void testReport1() throws Exception{
		System.out.println("hi");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(" clicked on OK alert");
		waitForElementThenClick(BiResourcesTab, 30);
		waitForElementThenClick(SearchButton, 30);
		waitForElementThenType(SearchReportsTab, 30, searchName);
		waitForElementThenClick(findTab, 30);
		waitForElementThenClick(ShippinggahOldReportClick, 30);
		Thread.sleep(1000);
		//waitForElementThenClick(BuisinessUnit,30);
		driver.switchTo().frame(driver.findElement(By.id("iframe-1")));
		
		System.out.println("url is "+driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		/*
		try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('tmplbusunit_drpdwn_hGroup001').selectedIndex = 1;");
		}catch(Exception e){
			
			System.out.print("script failed");
		} */
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(By.id("tmplbusunit_drpdwn_hGroup001")));
		//select.deselectAll();
		select.selectByIndex(3);
		
		System.out.println("Select element ");
		
		Thread.sleep(3000);
	
	
		Select select2 = new Select(driver.findElement(By.id("tmplval_drpdwn_hGroup001")));
		//select2.deselectAll();
		select2.selectByIndex(1);
		
		waitForElementThenClick(By.xpath("//*[@id='rep_output_opts_hGroup001']/table/tbody/tr[1]/td[8]"),30);
	
	
		
		waitForElementThenClick(By.xpath("//*[@id='reprunbtn_hGroup001']"),30);
		
		
	
	}
	
	
		
	}
	
	

