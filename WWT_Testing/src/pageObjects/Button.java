package pageObjects;

import org.openqa.selenium.WebElement;

import utility.Util;

public class Button extends PageObjects {
	
	public WebElement element = null;
	public String locator = null ;
	public int waitTime = Util.MAX_WAIT;
	
	public Button(String plocator){
		locator = plocator;
		element	= getElement(locator);
	}
	
	public void click(){
		
	try{
		
	    super.waitForElement(element, Util.MAX_WAIT);
		element.click();
	}catch(Exception e){
		
		System.out.println("element not found"+element);
	}
	
	}
	
	public void clickAndWait(String locator, int timeout){
		
		try{
			
		    super.waitForElement(element, Util.MAX_WAIT);
			element.click();
		}catch(Exception e){
			
			System.out.println("element not found"+element);
		}
		
		super.waitForElementToAppear(super.getElement(locator), timeout);
		
		}
	
}
