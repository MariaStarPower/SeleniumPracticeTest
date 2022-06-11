package automation;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchWindowTest extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeTest
	// Initialize the WebDriver
	public void initialize() throws IOException {
		
		driver = initializeWebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	// Close the browser
	public void closeDown() {
		
		driver.quit();
	}
	
	@Test
	// Verify that a new window is opened when Open Window is clicked
	public void switchWindowExample() {
		
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		
		openWindow.click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentWindow = it.next();	// Parent window
		String childWindow = it.next();		// Child window
		
		driver.switchTo().window(childWindow);		// Switch to child window
		
		String newWindowURL = driver.getCurrentUrl();
		System.out.println(newWindowURL);
		
		String newWindowTitle = driver.getTitle();
		System.out.println(newWindowTitle);
		
		driver.switchTo().window(parentWindow);		// Switch back to parent window	
	}
}
