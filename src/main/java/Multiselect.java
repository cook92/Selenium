import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Multiselect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		
		
		Select multiselect = new Select (driver.findElement(By.id("multi-select")));
		
		
		if(multiselect.isMultiple()) {
	    	
	    	System.out.println("This is a Multiple Drop down"); 	
	    	
	    	multiselect.selectByIndex(0);
	    	multiselect.selectByIndex(1);
	    	multiselect.selectByIndex(2);
	    	multiselect.selectByIndex(3);
	    	
	    	List<WebElement> soption = multiselect.getAllSelectedOptions();
	    	
	    	
	    	for (WebElement webElement : soption) {
	    		
	    		System.out.println("Selected Option");
	    		
	    		System.out.println(webElement.getText());
				
			}
	    	
	    }
		
	//driver.close();
	}

}
