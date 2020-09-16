import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Dropdown {
	
	

	public static void main(String[] args) throws IOException {

		Take_SS ss = new Take_SS();
		
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		Select dropdown = new Select(driver.findElement(By.id("select-demo")));
		
		

		if (dropdown.isMultiple()) {

			System.out.println("This is a Multiple Drop down");

		} else {

			System.out.println("This is not a multiple Dropdown");

			List<WebElement> alloptions = dropdown.getOptions();

			for (WebElement webElement : alloptions) {

				System.out.println("Option" + webElement.getText());

			}

			dropdown.selectByIndex(1);
			
			
			
			ss.takeSS(driver, "src/main/resources/dropdown.png");
			
			
		}

		// driver.close();
	}

	
	
	
	
}
