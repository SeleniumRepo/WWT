package pageObjects;

import org.openqa.selenium.WebElement;

import utility.Util;

public class Link extends PageObjects{
	
	public WebElement element = null;
	public String locator = null ;
	public int waitTime = Util.MAX_WAIT;
	
	public Link(String pLocator){
		
		locator = pLocator;
		element = getElement(pLocator);
	}
	
	public void click(){
		
		element.click();//@Todo: need to make more robust. 
	}
}
