package pageObjects;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

@SuppressWarnings("deprecation")
public class PageObjects extends SeleneseTestCase {

	// Common variables
	public Selenium selenium;
	public static WebDriver driver = new FirefoxDriver();
	public String baseUrl = "https://www-dev.wwt.com/puma";
	public String sample = "TestSearch1234";
	public String variety = "variety";
	public boolean result;
	public String SecuredUrl = "https://secure-dev.wwt.com/nidp/idff/sso?id=4&sid=1&option=credential&sid=1/";
	public String Puma = "https://www-dev.wwt.com/puma";
	
	public int LoginDataRows, LoginDataCols;
	public static String[][] LoginData;
	public static String filepath = "C:/Users/kakanis.WWTHC/workspace/pumaAdvancedTests/pumaAdvancedTests/InputFiles/LoginData.xls";
	
	private By projectNumberTextBox = By
			.xpath("//*[@id='s2id_projectNumber']/ul/li/input");
	private By projectSummaryTextBox = By.linkText("Project Summary");
	private By AdvancedSearchTextBox = By
			.cssSelector(".pui-fieldset-legend.ui-corner-all.ui-state-default");
	private By projectManagerTextBox = By
			.xpath("//*[@id='s2id_projectManager']/ul/li/input");
	private By projectManagerDropDown = By
			.cssSelector(".select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted");
	private By selectTab = By
			.cssSelector(".ui-menu.ui-widget.ui-widget-content.ui-corner-all");
	private By deleteConfirmationDialog = By
			.xpath("//*[@id='deleteConfirmationDialog']");
	private By projectNumberListBox = By
			.cssSelector("[id='select2-drop'] > ul[class='select2-results'] > li > div");
	private By projectNumberDropdown = By
			.cssSelector(".select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted");
	private By customerNameTextBox = By
			.xpath("//*[@id='s2id_customerName']/ul/li/input");
	private By customerNameDropDown = By
			.cssSelector(".select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted");
	private By advancedSavedSearchTextBox = By
			.cssSelector("#advanceSearchButton");
	private By advanceSavedSearchOptions = By
			.xpath(".//*[@id='s2id_saveAdvancedSearch']/a/span");
	private By advancedSavedSearchDropDown = By
			.cssSelector(".select2-choice.select2-default");
	private By dropDownList = By.xpath(".//*[@id='select2-drop']");
	private By advancedSavedSearchFocused = By
			.cssSelector(".select2-input.select2-focused");
	private By advancedSavedSearchDropDownSelected = By
			.xpath("//*[@id='select2-drop']/ul/li/div/div");
	//select2-results-dept-0 select2-result select2-result-selectable select2-highlighted
	//AdvancedSavedVarietySearch
	private By AdvancedSavedVarietySearch = By.xpath("//*[@id='select2-drop']/ul/li[8]/div/div");
	
	//private By AdvancedSavedVarietySearch = By.cssSelector(".select2-results-dept-0 select2-result select2-result-selectable select2-highlighted");
	private By LogOut = By.linkText("Logout");

	// setup system properties
	@BeforeClass
	public void setUp() throws Exception {

		System.out.println("setting up web browser");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("webbrowser opened");
		System.out.println("WWT.com");
		
		
        // Read Login Data from Excel
        LoginData= dataLoad.ExcelFile.ReadMyExcel(filepath, "LoginData");
        LoginDataRows=LoginData.length;
        LoginDataCols=LoginData[1].length;
        
        System.out.println(LoginData[1][0]);
        System.out.println(LoginData[1][1]);
        
        login();

	}

	public void listAllProjectNumber() {
		List<WebElement> allDropdownOptions = driver
				.findElements(projectNumberListBox);

		for (WebElement eachElement : allDropdownOptions) {
			System.out.println("print all the 109 options"
					+ eachElement.getText());
		}
	}
 @Deprecated
	public WebElement waitForElement(By elementId, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementId));
			System.out.println("element found " + elementId);
			return driver.findElement(elementId);
		} catch (Exception e) {
			System.out.println("element not found " + elementId);
			return null;
		}

	}
	public WebElement waitForElement(WebElement element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("element found " + element);
			return element;
		} catch (Exception e) {
			System.out.println("element not found " + element);
			return null;
		}

	}

	// /Waits for a webelement and returns true if found or fail if not found
	// /<Returns> True if elment is found in the given time or returns false
	// /<Parameter elementId > the id of the element we are looking for
	// /<Parameter timeoutInSeconds> number of seconds to wait for the element
	public boolean waitForElementToAppear(By elementId, int time) {
		if (waitForElement(elementId, time) != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean waitForElementToAppear(WebElement element, int time) {
		if (waitForElement(element, time) != null) {
			return true;
		} else {
			return false;
		}
	}
	// /Waits for a webelement and clicks on the element
	// /<Parameter elementId > the id of the element we are looking for
	// /<Parameter timeoutInSeconds> number of seconds to wait for the element
	public void waitForElementThenClick(By elementId, int timeoutInSeconds) {
		try {
			WebElement element = waitForElement(elementId, timeoutInSeconds);
			element.click();
		} catch (Exception e) {
			// System.out.println("");
		}
	}

	// /Waits for a webelement and clicks on the element
	// /<Parameter elementId > the id of the element we are looking for
	// /<Parameter timeoutInSeconds> number of seconds to wait for the element
	public void waitForElementThenType(By elementId, int timeoutInSeconds,
			String text) {
		try {
			WebElement element = waitForElement(elementId, timeoutInSeconds);
			element.sendKeys(text);
		} catch (Exception e) {

		}
	}
	
	// /Waits for a webelement and clicks on the element
		// /<Parameter elementId > the id of the element we are looking for
		// /<Parameter timeoutInSeconds> number of seconds to wait for the element
		public void waitForElementThenType(WebElement pelement, int timeoutInSeconds,
				String text) {
			try {
				WebElement element = waitForElement(pelement, timeoutInSeconds);
				element.sendKeys(text);
			} catch (Exception e) {

			}
		}
	
	public void clearText(WebElement element ){
		
		element.clear();
		
	}

	// /Selects an option from a drop down
	// /<Parameter "text" > the text of the option to be selected
	public void selectByText(By elementId, String text) {
		WebElement element = waitForElement(elementId, 30);
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(text);
	}

	public void login() throws Exception
	{
		driver.get(SecuredUrl);
		System.out.println("frame");
		
		// Waits and checks till the login form is found
		if (waitForElementToAppear(By.id("login"), 60)) {
			waitForElementThenType(By.id("username"), 30, LoginData[1][0]);
			waitForElementThenType(By.id("password"), 30, LoginData[1][1]);
			waitForElementThenClick(By.id("submit"), 30);
			System.out.println("successfully logged in");
		
		}
		else
		{
			fail("Login form not found");
		}
		
		driver.get("https://www-dev.wwt.com/puma"); // Redirecting back to actual wwt url
	}

	public void verifyAndClickProjectSummary() throws Exception {
		waitForElementThenClick(projectSummaryTextBox, 30); // Clicks on Project
															// Summary
	}

	public void verifyAndClickAdvancedSearch() throws Exception {
		waitForElementThenClick(AdvancedSearchTextBox, 30); // Clicks on
															// Advanced Search
	}

	public void verifyAndEnterProjectNumber() throws Exception {
		waitForElementThenType(projectNumberTextBox, 30, "123");

		// Clicks on the first element on the dropdown
		waitForElementThenClick(projectNumberDropdown, 30);

		if (waitForElementToAppear(By.cssSelector(".select2-search-choice"), 30)) {
			System.out.println("clicked on element");
		} else {
			fail("element not found");
		}
	}

	public void verifyAndEnterSearchName(String searchName) throws Exception {
		waitForElementThenClick(advancedSavedSearchTextBox, 30);// Clicks on
																// 'Save/Lookup
																// Advanced
																// Search'
																// dropdown
																// container

		waitForElementThenClick(advancedSavedSearchDropDown, 30);

		waitForElementThenType(advancedSavedSearchFocused, 30, searchName);

		waitForElementThenClick(advancedSavedSearchDropDownSelected, 30);

	}
	public void verifyAndEnterSavedSearchName() throws Exception {
		waitForElementThenClick(advancedSavedSearchTextBox, 30);// Clicks on
																// 'Save/Lookup
																// Advanced
																// Search'
																// dropdown
																// container

		waitForElementThenClick(advancedSavedSearchDropDown, 30);

		waitForElementThenType(AdvancedSavedVarietySearch, 30, variety);
		{
			System.out.println("Previously saved search has been fired automatically without clicking on 'Execute Search'");
		}
		waitForElementThenClick(advancedSavedSearchDropDownSelected, 30);

	}

	public void clearSearchProjectNumberInSample() {

		waitForElementThenClick((projectNumberTextBox), 30);

	}

	public void verifyAndEnterCustomerName() {

		waitForElementThenType(customerNameTextBox, 30, "por");

		// Clicks on the first element on the dropdown
		waitForElementThenClick(customerNameDropDown, 30);

		if (waitForElementToAppear(By.cssSelector(".select2-search-choice"), 30)) {
			System.out.println("clicked on element");
		} else {
			fail("element not found");
		}

	}

	public void verifiesandSavesSaveForFutureReference() {

		if (waitForElementToAppear(
				By.cssSelector(".ui-menu.ui-widget.ui-widget-content.ui-corner-all"),
				30)) {

			List<WebElement> elements = driver.findElements(By
					.cssSelector(".ui-menu-item"));

			for (int i = 0; i < elements.size(); i++) {

				WebElement element = elements.get(i).findElement(
						By.cssSelector(".ui-corner-all"));

				if (i == 0) {
					assertTrue(element.getText().equals("Save/Update"));
					element.click();
					break;
				}
			}

			String sampletext = driver.findElement(
					By.cssSelector(".select2-choice>span")).getText();

			if (sampletext.compareTo(sample) == 0) {
				System.out.println("Search name is saved for future reference");
			} else {
				fail("Failed to save the search name");
			}
		}
	}

	public void verifiesToDeleteTheSavedSearchSample() {

		if (waitForElementToAppear(
				By.xpath("//*[@id='toggle']/div/table/tbody/tr[2]/td[4]/div[3]/ul/li[2]/a"),
				30)) {
			List<WebElement> elements = driver.findElements(By
					.cssSelector(".ui-menu-item"));
			for (int i = 1; i < elements.size(); i++) {
				WebElement element = elements.get(i).findElement(
						By.cssSelector(".ui-corner-all"));
				if (i == 1) {
					assertTrue(element.getText().equals("Delete"));
					element.click();
					break;
				}
			}
			String sampletext = driver.findElement(
					By.cssSelector(".select2-choice>span")).getText();
			if (sampletext.compareTo(sample) == 0) {
				System.out.println("Delete element is present");
			} else {
				fail("Failed to delete the search name");
			}
			waitForElementThenClick(
					By.xpath("//*[@id='deleteConfirmationDialog']"), 30);
			System.out.println("Search name is deleted from the record");
		}
	}

	public void verifyAndEnterProjectManagerName() {
		waitForElementThenType(projectManagerTextBox, 30, "nik");

		// Clicks on the first element on the dropdown
		waitForElementThenClick(projectManagerDropDown, 30);

		if (waitForElementToAppear(By.cssSelector(".select2-search-choice"), 30)) {
			System.out.println("clicked on element");
		} else {
			fail("element not found");
		}
	}

	public void listAllProjectNumbersWith109() {
		waitForElementThenClick((projectNumberTextBox), 30);
		waitForElementThenType((projectNumberTextBox), 30, "109");
		waitForElement(By.cssSelector("select2-drop"), 30);
		List<WebElement> allDropdownOptions = driver.findElements(dropDownList);
		for (WebElement eachElement : allDropdownOptions) {
			eachElement.click();
			System.out.println("List all ProjectNumbers with 109"
					+ eachElement.getText());
		}
	}

	public void clickSelect() throws Exception {
		waitForElementThenClick(By.id("select"), 30);

	}

	public void verifyTabsInSelect() throws Exception {
		driver.findElement(selectTab).isDisplayed();

		List<WebElement> elements = driver.findElements(By
				.cssSelector(".ui-menu-item"));

		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i).findElement(
					By.cssSelector(".ui-corner-all"));

			if (i == 0) {

				assertTrue(element.getText().equals("Save/Update"));
			} else if (i == 1) {
				assertTrue(element.getText().equals("Delete"));
			}
		}
	}

	public void listAllSavedSearches() {
		waitForElementThenClick(advanceSavedSearchOptions, 30);
		List<WebElement> allDropdownOptions = driver.findElements(dropDownList);
		for (WebElement eachElement : allDropdownOptions) {
			eachElement.click();
			System.out.println("List all saved searches"
					+ eachElement.getText());
		}
	}

	public void savesTheAdvanceSearchElement() {
		if (waitForElementToAppear(By.cssSelector(".select2-choice>span"), 30)) {

			List<WebElement> elements = driver.findElements(By
					.cssSelector(".ui-menu-item"));

			for (int i = 0; i < elements.size(); i++) {

				WebElement element = elements.get(i).findElement(
						By.cssSelector(".ui-corner-all"));

				if (i == 0) {
					assertTrue(element.getText().equals("Save/Update"));
					element.click();
					break;
				}
			}

			String sampletext = driver.findElement(
					By.cssSelector(".select2-choice>span")).getText();

			if (sampletext.compareTo(sample) == 0) {
				System.out
						.println("Search Projectname is saved for future reference");
			} else {
				fail("Failed to save the search name");
			}
		}
	}

	public void confirmationBoxAppears() {
		if (waitForElementToAppear(
				By.xpath("//*[@id='toggle']/div/table/tbody/tr[2]/td[4]/div[3]/ul/li[2]/a"),
				30)) {
			List<WebElement> elements = driver.findElements(By
					.cssSelector(".ui-menu-item"));
			for (int i = 1; i < elements.size(); i++) {
				WebElement element = elements.get(i).findElement(
						By.cssSelector(".ui-corner-all"));
				if (i == 1) {
					assertTrue(element.getText().equals("Delete"));
					element.click();
					break;
				}
			}
			String sampletext = driver.findElement(
					By.cssSelector(".select2-choice>span")).getText();
			if (sampletext.compareTo(sample) == 0) {
				System.out.println("Delete element is present");
			} else {
				fail("Failed to delete the search name");
			}
			waitForElementThenClick(
					By.xpath("//*[@id='toggle']/div/table/tbody/tr[2]/td[4]/div[3]/ul/li[2]/a"),
					30);
			waitForElementToAppear((deleteConfirmationDialog), 30);
		}
	}

	public void logOut() throws Exception {
		waitForElementThenClick(LogOut, 30);
		System.out.println("Successfully logs out of the system");
	}
	
  public WebElement getElement(String plocator){
		
		String locator = null; 
		WebElement element = null ;
		if(plocator.startsWith("id")){
			locator = plocator.split("id=")[1];
			System.out.println("locator is"+ locator);
		   element =	driver.findElement(By.id(locator));
		}
		else if(plocator.startsWith("//")){
			
			locator = plocator;
			System.out.println("Element Locator starts with // "+locator);
			element = driver.findElement(By.xpath(locator));
			
			
		} else if(plocator.startsWith("name")){
			
			locator = plocator.split("name=")[1];
			System.out.println("Element Locator is "+locator);
		    element = driver.findElement(By.name(locator));
		} else if(plocator.startsWith("css=")){
			
			locator = plocator.split("css=")[1];
			//locator = plocator;
			System.out.println("Element Locator is css "+locator);
			element = driver.findElement(By.cssSelector(locator));
		} else if(plocator.startsWith("class=")){
			
			locator = plocator.split("class=")[1];
			System.out.println("Element Locator is "+locator);
			element = driver.findElement(By.className(locator));
		}
		return element;
		
	}
  
	@AfterClass
	public void tearDown() throws Exception {
		logOut();
		driver.close();
		driver.quit();
	}
}
