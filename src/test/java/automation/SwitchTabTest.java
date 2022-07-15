package automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwitchTabTest extends BaseClass {
	
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
