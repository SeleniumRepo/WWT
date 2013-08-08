package com.wwt.test.puma.pumaSearchTests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;






import pageObjects.PageObjects;

public class AdvancedSearchTestCases extends PageObjects {

	
	String name = "search123";
	String name1 = "search123";
	String name2 = "search123";
	String name3 = "search123";
	String name4 = "search123";
@Test
public void testSearchTest_1SaveForFutureReference() throws Exception {
			
	
			verifyAndClickProjectSummary();
			verifyAndClickAdvancedSearch();
			verifyAndEnterProjectNumber();
			verifyAndEnterSearchName(name);
			//verifyAndEnterSearchName(name1);
			//verifyAndEnterSearchName(name2);
			//verifyAndEnterSearchName(name3);
			clickSelect();
			verifiesandSavesSaveForFutureReference();
			
		}


@Test()
public void testSearchTest_2VerifyToolIconElements() throws Exception {

	
	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	clickSelect();
	verifyTabsInSelect();
	
		}

@Test
public void testSearchTest_3SearchFireAutomatically() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	verifyAndEnterSavedSearchName();
		
	
}
@Test
public void testSearchTest_4DeleteSavedSearchAndSave() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	verifyAndEnterSearchName(name);
	clearSearchProjectNumberInSample();
	verifyAndEnterCustomerName();
	clickSelect();
	savesTheAdvanceSearchElement();
	
}
@Test
public void testSearchTest_5AddingFieldsToSavedSearch() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	verifyAndEnterSearchName(name);
	verifyAndEnterProjectManagerName();
	clickSelect();
	verifiesandSavesSaveForFutureReference();
	
}


@Test
public void testSearchTest_6DeleteTheSavedSearch() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	verifyAndEnterSearchName(name);
	clickSelect();
	verifiesToDeleteTheSavedSearchSample();
	
}

@Test
public void testSearchTest_7ListAllSavedSearchesPresent() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	listAllSavedSearches();
	
}
@Test
public void testSearchTest_8ConfirmationBoxAppears() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	verifyAndEnterSearchName(name);
	clickSelect();
	confirmationBoxAppears();
	
}

@Test
public void testSearchTest_9DisplayAllProjectNumbersWith109() throws Exception {

	verifyAndClickProjectSummary();
	verifyAndClickAdvancedSearch();
	listAllProjectNumbersWith109();
	
}

}




