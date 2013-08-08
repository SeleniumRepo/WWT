
package pumaAdvancedTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

@SuppressWarnings("deprecation")
public class PageObjects {

	//Common variables
	 public Selenium selenium;
	 public static  WebDriver driver = new FirefoxDriver();
	 public String baseUrl = "https://www-dev.wwt.com/";
	 public String sample = "sample";
     public boolean result;
	

	
	
  public WebElement getElement(String plocator){
		
		String locator = null; 
		WebElement element = null ;
		if(plocator.startsWith("id")){
			locator = plocator.split("id=")[1];
			System.out.println("locator is"+ locator);
		   element =	driver.findElement(By.id(locator));
		}
		if(plocator.startsWith("//")){
			
			element = driver.findElement(By.xpath(locator));
		}
		return element;
		
	}

  public void waitForElementPresent(){
	
	
}
  
  
	
	public void tearDown() throws Exception {		
		driver.close();
		driver.quit();
	}

	public void waitForElementThenType(By xpath, int i) {
		// TODO Auto-generated method stub
		
	}
}



