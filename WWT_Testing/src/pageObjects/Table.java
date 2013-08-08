package pageObjects;

import org.openqa.selenium.WebElement;

import utility.Util;

public class Table extends PageObjects{
	public WebElement element = null;
	public String locator = null ;
	public int waitTime = Util.MAX_WAIT;
	public Table(String plocator){
		locator = plocator;
		element	= getElement(locator);
		
	}
	
	//@Todo: get the cell data from a table

}
