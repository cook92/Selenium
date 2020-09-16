import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions_Robot_Wait {

	public static void main(String[] args) throws AWTException {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		

		/*
		 * doubleClick(): Performs double click on the element clickAndHold(): Performs
		 * long click on the mouse without releasing it dragAndDrop(): Drags the element
		 * from one point and drops to another moveToElement(): Shifts the mouse pointer
		 * to the center of the element contextClick(): Performs right-click on the
		 * mouse
		 * 
		 * Keyboard Actions:
		 * 
		 * sendKeys(): Sends a series of keys to the element keyUp(): Performs key
		 * release keyDown(): Performs keypress without release
		 */

		Actions builder = new Actions(driver);

		driver.get("https://www.flipkart.com/");

		Robot robot = new Robot();

		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		// implict wait

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Explict wait

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[3]"))));
		WebElement mensection = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[3]"));
		builder.moveToElement(mensection).moveToElement(driver.findElement(By.linkText("Formal Shoes"))).click().build()
				.perform();

	}

}
