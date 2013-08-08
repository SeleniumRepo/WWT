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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

@SuppressWarnings("deprecation")
public class loginsnobird extends SeleneseTestCase {

	// Common variables
	public Selenium selenium;
	public WebDriver driver;
	public String baseUrl = "https://www-dev.wwt.com/snobird";
	public boolean result;
	public String SecuredUrl = "https://secure-dev.wwt.com/nidp/idff/sso?id=4&sid=1&option=credential&sid=1/";
	public String SnoBird = "https://www-dev.wwt.com/snobird";
	
	public int LoginDataRows, LoginDataCols;
	public static String[][] LoginData;
	public static String filepath = "C:\\Users\\amuppidi\\workspace_kepler\\puma\\InputFiles\\LoginData.xls";
	
	
	
	private By LogOut = By.linkText("Logout");

	// setup system properties
	@BeforeClass
	public void setUp() throws Exception {

		System.out.println("setting up web browser");
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("browser.download.dir","C:\\Users\\amuppidi\\workspace_kepler\\puma\\downloads");
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv"); 
		
		driver = new FirefoxDriver(fp);
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
		
		driver.get("https://www-dev.wwt.com/snobird"); // Redirecting back to actual wwt url
	}


	public void logOut() throws Exception {
		waitForElementThenClick(LogOut, 30);
		System.out.println("Successfully logs out of the system");
	}

	@AfterClass
	public void tearDown() throws Exception {
		logOut();
		driver.close();
		driver.quit();
	}
}
