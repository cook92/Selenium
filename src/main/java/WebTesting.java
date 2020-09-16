import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTesting {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		
		// Window Handles (Switching between the tabs )

		String Currentwindowname = driver.getWindowHandle();

		Set<String> wndow = driver.getWindowHandles();

		for (String string : wndow) {

			if (string != Currentwindowname) {

				driver.switchTo().window(string);
				
				String tileofswitchedpage = driver.getTitle();
				
				if(tileofswitchedpage==" New Tab 1") {
					
					
					
					
				}
			

			}
		}
		
		
		driver.switchTo().window(Currentwindowname);
		
		

		// dropdown select
       //http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
		
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		
		
		    Select dropdown = new Select(driver.findElement(By.id("select-demo")));	
		    
		    
		    if(dropdown.isMultiple()) {
		    	
		    	System.out.println("This is a Multiple Drop down"); 		
		    	
		    	
		    }else {
		    	
		    	System.out.println("This is not a multiple Dropdown");
		    	
		    	List<WebElement> alloptions = dropdown.getOptions();
		    	
		    	for (WebElement webElement : alloptions) {
		    		
		    		webElement.getText();
					
				}
		    	
		    	dropdown.selectByIndex(0);
		    }
		
			
		    driver.close();
		
		
		// dropdown multiselect
		
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
			
		driver.close();
			
			
			
			
			

		// Actions in Selenium 
			
		    /*doubleClick(): Performs double click on the element
		    clickAndHold(): Performs long click on the mouse without releasing it
		    dragAndDrop(): Drags the element from one point and drops to another
		    moveToElement(): Shifts the mouse pointer to the center of the element
		    contextClick(): Performs right-click on the mouse

		Keyboard Actions:

		    sendKeys(): Sends a series of keys to the element
		    keyUp(): Performs key release
		    keyDown(): Performs keypress without release
*/
			
			
			Actions builder = new Actions(driver);
			
			
			driver.get("https://www.flipkart.com/");
			
			 Robot robot = new Robot();
			 
			 robot.keyPress(KeyEvent.VK_ESCAPE);
			 robot.keyRelease(KeyEvent.VK_ESCAPE);
				
	         	
			//implict wait
			 
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			//Explict wait
			
			WebDriverWait wait = new WebDriverWait(driver, 3);			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[3]"))));			
			WebElement mensection = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[3]"));
			builder.moveToElement(mensection).moveToElement(driver.findElement(By.linkText("Formal Shoes"))).click().build().perform();
			

	}

}
