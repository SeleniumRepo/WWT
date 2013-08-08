package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectList extends PageObjects {
	
	private  WebElement element = null;
	public SelectList(String elementLocator){
		
		element =getElement(elementLocator);
	}
	
	public void selectOption(String value){
	Select select = new Select(element);
	select.deselectAll();
	select.selectByVisibleText(value);
	}
	
	public void selectOption(String[] values){
		Select select = new Select(element);
		select.deselectAll();
		for(String v: values){
	     	select.selectByVisibleText(v);
		 }
		}
	public void selectAllOptions(){
		Select select = new Select(element);
	
		//@Todo: select all option logic
		}
}
