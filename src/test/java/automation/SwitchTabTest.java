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

public class SwitchTabTest extends BaseClass {
	
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
	// Verify that a new tab is opened when Open Tab is clicked
	public void switchTabExample() {
		
		WebElement openTab = driver.findElement(By.id("opentab"));
		
		openTab.click();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> i = tabs.iterator();
		
		// Main tab
		String parentTab = i.next();
		// Child tab
		String childTab = i.next();
		
		driver.switchTo().window(childTab);		// Switch to child tab
		
		String newTabURL = driver.getCurrentUrl();
		System.out.println(newTabURL);
		
		String newTabTitle = driver.getTitle();
		System.out.println(newTabTitle);
		
		driver.switchTo().window(parentTab);	// Switch back to main tab
	}

}
