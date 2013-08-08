package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InputField extends PageObjects{
	public WebElement element = null;
	public String locator = null ;
	
	public InputField(String plocator){
		locator = plocator;
		element	= getElement(locator);
	}
	
	
	
	public void inputText(String text){
		
	   super.clearText(element);
	   super.waitForElementThenType(element, 1000, text);
		
	}
	
	public void clear(){
		
		super.clearText(element);
	}
	

}
